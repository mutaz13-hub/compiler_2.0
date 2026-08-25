package Util;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Generic reflection-based JSON exporter for this project's AST node
 * classes (AST.Python.Root and its subclasses, Jinja.JinjaNode and its
 * subclasses). Rather than writing a hand-built JSON serializer per AST
 * (which would duplicate the same "walk every getter" logic twice), this
 * walks any object's public zero-argument getters via reflection and
 * recurses into whatever they return - Lists become JSON arrays, nested
 * AST-node-shaped objects (anything with a getLine() method) become
 * nested JSON objects tagged with their class name, and everything else
 * (String, primitives, enums) becomes a JSON leaf value.
 *
 * This is what produces compiler_output/ast_python.json and
 * ast_jinja.json - the same two hand-written ASTs this project already
 * builds and prints as text, just serialized as JSON instead.
 */
public class JsonExporter {

    public static String toJson(Object obj) {
        StringBuilder sb = new StringBuilder();
        write(obj, sb, 0);
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static void write(Object obj, StringBuilder sb, int depth) {
        if (depth > 60) { sb.append("\"<max depth>\""); return; } // guard against accidental cycles

        if (obj == null) {
            sb.append("null");
        } else if (obj instanceof String) {
            sb.append('"').append(escape((String) obj)).append('"');
        } else if (obj instanceof Number || obj instanceof Boolean) {
            sb.append(obj);
        } else if (obj instanceof Enum) {
            sb.append('"').append(((Enum<?>) obj).name()).append('"');
        } else if (obj instanceof List) {
            List<Object> list = (List<Object>) obj;
            if (list.isEmpty()) { sb.append("[]"); return; }
            sb.append("[\n");
            for (int i = 0; i < list.size(); i++) {
                indent(sb, depth + 1);
                write(list.get(i), sb, depth + 1);
                sb.append(i < list.size() - 1 ? ",\n" : "\n");
            }
            indent(sb, depth);
            sb.append("]");
        } else if (isAstNode(obj)) {
            writeAstNode(obj, sb, depth);
        } else {
            // Fallback leaf (e.g. a plain wrapper class not part of the AST) - use its own text form.
            sb.append('"').append(escape(String.valueOf(obj))).append('"');
        }
    }

    /** "Looks like one of this project's AST node classes" - has a getLine() method. */
    private static boolean isAstNode(Object obj) {
        try {
            obj.getClass().getMethod("getLine");
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private static void writeAstNode(Object obj, StringBuilder sb, int depth) {
        sb.append("{\n");
        indent(sb, depth + 1);
        sb.append("\"node\": \"").append(obj.getClass().getSimpleName()).append("\"");

        for (Method m : obj.getClass().getMethods()) {
            if (m.getParameterCount() != 0) continue;
            if (!m.getName().startsWith("get") || m.getName().equals("getClass")) continue;
            if (m.getName().equals("getLine")) {
                try {
                    sb.append(",\n"); indent(sb, depth + 1);
                    sb.append("\"line\": ").append(m.invoke(obj));
                } catch (Exception ignored) { }
                continue;
            }
            String fieldName = decapitalize(m.getName().substring(3));
            try {
                Object value = m.invoke(obj);
                if (value == null) continue; // omit unset fields rather than clutter the output with nulls
                sb.append(",\n"); indent(sb, depth + 1);
                sb.append('"').append(fieldName).append("\": ");
                write(value, sb, depth + 1);
            } catch (Exception ignored) {
                // A getter that fails to invoke cleanly (e.g. needs args we didn't detect) is simply skipped.
            }
        }
        sb.append("\n"); indent(sb, depth); sb.append("}");
    }

    private static String decapitalize(String s) {
        if (s.isEmpty()) return s;
        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

    private static void indent(StringBuilder sb, int depth) {
        sb.append("  ".repeat(depth));
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"")
                .replace("\n", "\\n").replace("\r", "");
    }
}
