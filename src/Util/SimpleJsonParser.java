package Util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Minimal recursive-descent JSON reader used to load data files like
 * test/products_data.json into plain Java objects (Map/List/String/
 * Long/Double/Boolean/null) so that data can be fed straight into the
 * Jinja rendering context. This is the read-side counterpart to
 * Util.JsonExporter (which only writes).
 */
public class SimpleJsonParser {

    private final String s;
    private int pos;

    private SimpleJsonParser(String s) {
        this.s = s;
        this.pos = 0;
    }

    public static Object parse(String text) {
        SimpleJsonParser p = new SimpleJsonParser(text);
        p.skipWs();
        return p.parseValue();
    }

    private Object parseValue() {
        skipWs();
        char c = s.charAt(pos);
        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (c == 't' || c == 'f') return parseBoolean();
        if (c == 'n') { pos += 4; return null; }
        return parseNumber();
    }

    private Map<String, Object> parseObject() {
        Map<String, Object> map = new LinkedHashMap<>();
        pos++; // {
        skipWs();
        if (peek() == '}') { pos++; return map; }
        while (true) {
            skipWs();
            String key = parseString();
            skipWs();
            pos++; // :
            map.put(key, parseValue());
            skipWs();
            if (peek() == ',') { pos++; continue; }
            if (peek() == '}') { pos++; break; }
            break;
        }
        return map;
    }

    private List<Object> parseArray() {
        List<Object> list = new ArrayList<>();
        pos++; // [
        skipWs();
        if (peek() == ']') { pos++; return list; }
        while (true) {
            list.add(parseValue());
            skipWs();
            if (peek() == ',') { pos++; continue; }
            if (peek() == ']') { pos++; break; }
            break;
        }
        return list;
    }

    private String parseString() {
        pos++; // opening quote
        StringBuilder sb = new StringBuilder();
        while (s.charAt(pos) != '"') {
            char c = s.charAt(pos);
            if (c == '\\') {
                pos++;
                char esc = s.charAt(pos);
                switch (esc) {
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    case 'r': sb.append('\r'); break;
                    case 'b': sb.append('\b'); break;
                    case 'f': sb.append('\f'); break;
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'u':
                        sb.append((char) Integer.parseInt(s.substring(pos + 1, pos + 5), 16));
                        pos += 4;
                        break;
                    default: sb.append(esc);
                }
                pos++;
            } else {
                sb.append(c);
                pos++;
            }
        }
        pos++; // closing quote
        return sb.toString();
    }

    private Boolean parseBoolean() {
        if (s.startsWith("true", pos)) { pos += 4; return Boolean.TRUE; }
        pos += 5;
        return Boolean.FALSE;
    }

    private Object parseNumber() {
        int start = pos;
        while (pos < s.length() && "-+.0123456789eE".indexOf(s.charAt(pos)) >= 0) pos++;
        String num = s.substring(start, pos);
        if (num.contains(".") || num.contains("e") || num.contains("E")) return Double.parseDouble(num);
        try {
            return Long.parseLong(num);
        } catch (NumberFormatException e) {
            return Double.parseDouble(num);
        }
    }

    private char peek() { return s.charAt(pos); }

    private void skipWs() {
        while (pos < s.length() && Character.isWhitespace(s.charAt(pos))) pos++;
    }
}
