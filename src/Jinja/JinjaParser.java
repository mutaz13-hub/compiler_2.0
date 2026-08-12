package Jinja;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand-written lexer + recursive-descent parser for the small subset of
 * Jinja2 this project needs: {{ expr }} output tags, and
 * {% for x in y %}...{% else %}...{% endfor %} / {% if c %}...{% else %}...{% endif %}
 * control blocks, interleaved with raw HTML text.
 *
 * NOTE on scope: a full Jinja2 grammar (filters, macros, arithmetic
 * expressions, etc.) is a large undertaking on its own; this covers
 * exactly the constructs your teammate's example and products.html use
 * (variable substitution + for-loops, matching the "products" data shape),
 * which is what's needed to demonstrate the Python-data -> Jinja-AST ->
 * HTML pipeline end to end. It's structured so ForNode/IfNode's siblings
 * can grow if more Jinja syntax is needed later.
 */
public class JinjaParser {

    private enum TokType { TEXT, VAR, STMT }

    private static class Tok {
        TokType type;
        String content;
        int line;
        Tok(TokType type, String content, int line) {
            this.type = type; this.content = content; this.line = line;
        }
    }

    private List<Tok> tokens;
    private int pos;

    public JinjaProgram parse(String source) {
        tokens = tokenize(source);
        pos = 0;
        JinjaProgram program = parseBlock(null);
        return program;
    }

    // ---------------- Lexer ----------------

    private List<Tok> tokenize(String src) {
        List<Tok> out = new ArrayList<>();
        int i = 0;
        int line = 1;
        int n = src.length();
        StringBuilder text = new StringBuilder();
        int textStartLine = 1;

        while (i < n) {
            int varStart = src.indexOf("{{", i);
            int stmtStart = src.indexOf("{%", i);
            int next = minPositive(varStart, stmtStart);

            if (next < 0) {
                text.append(src, i, n);
                i = n;
                break;
            }

            text.append(src, i, next);
            if (text.length() > 0) {
                out.add(new Tok(TokType.TEXT, text.toString(), textStartLine));
                line += countNewlines(text.toString());
                text.setLength(0);
            }

            if (next == varStart) {
                int end = src.indexOf("}}", next);
                if (end < 0) { text.append(src.substring(next)); break; }
                String inner = src.substring(next + 2, end);
                out.add(new Tok(TokType.VAR, inner, line));
                line += countNewlines(src.substring(next, end + 2));
                i = end + 2;
            } else {
                int end = src.indexOf("%}", next);
                if (end < 0) { text.append(src.substring(next)); break; }
                String inner = src.substring(next + 2, end);
                out.add(new Tok(TokType.STMT, inner.trim(), line));
                line += countNewlines(src.substring(next, end + 2));
                i = end + 2;
            }
            textStartLine = line;
        }
        if (text.length() > 0) {
            out.add(new Tok(TokType.TEXT, text.toString(), textStartLine));
        }
        return out;
    }

    private int minPositive(int a, int b) {
        if (a < 0) return b;
        if (b < 0) return a;
        return Math.min(a, b);
    }

    private int countNewlines(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '\n') c++;
        return c;
    }

    // ---------------- Parser ----------------

    /**
     * Parses tokens into a JinjaProgram until EOF or a token matching
     * `stopAt` (e.g. "endfor", "else", "endif") is reached. The stop
     * token itself is NOT consumed - the caller inspects it.
     */
    private JinjaProgram parseBlock(String[] stopAtAny) {
        JinjaProgram program = new JinjaProgram();
        while (pos < tokens.size()) {
            Tok tok = tokens.get(pos);
            if (tok.type == TokType.STMT && stopAtAny != null && matchesAny(tok.content, stopAtAny)) {
                break;
            }
            program.setLine(program.getChildren().isEmpty() ? tok.line : program.getLine());
            if (tok.type == TokType.TEXT) {
                program.addChild(new TextNode(tok.content, tok.line));
                pos++;
            } else if (tok.type == TokType.VAR) {
                program.addChild(new VarNode(tok.content, tok.line));
                pos++;
            } else { // STMT
                if (tok.content.startsWith("for ")) {
                    program.addChild(parseFor());
                } else if (tok.content.startsWith("if ")) {
                    program.addChild(parseIf());
                } else {
                    // Unknown/unsupported statement tag (e.g. block, set, macro) -
                    // skip it rather than fail the whole template.
                    pos++;
                }
            }
        }
        return program;
    }

    private boolean matchesAny(String content, String[] options) {
        for (String o : options) if (content.equals(o)) return true;
        return false;
    }

    private ForNode parseFor() {
        Tok forTok = tokens.get(pos);
        pos++; // consume "for ..."
        // "for product in products" -> loopVar="product", iterable="products"
        String[] parts = forTok.content.substring(4).trim().split("\\s+in\\s+", 2);
        String loopVar = parts.length > 0 ? parts[0].trim() : "item";
        String iterable = parts.length > 1 ? parts[1].trim() : "";

        JinjaProgram body = parseBlock(new String[]{"else", "endfor"});
        JinjaProgram elseBody = null;
        if (pos < tokens.size() && tokens.get(pos).content.equals("else")) {
            pos++; // consume "else"
            elseBody = parseBlock(new String[]{"endfor"});
        }
        if (pos < tokens.size() && tokens.get(pos).content.equals("endfor")) {
            pos++; // consume "endfor"
        }
        return new ForNode(loopVar, iterable, body, elseBody, forTok.line);
    }

    private IfNode parseIf() {
        Tok ifTok = tokens.get(pos);
        pos++; // consume "if ..."
        String condition = ifTok.content.substring(3).trim();

        JinjaProgram thenBody = parseBlock(new String[]{"else", "endif"});
        JinjaProgram elseBody = null;
        if (pos < tokens.size() && tokens.get(pos).content.equals("else")) {
            pos++; // consume "else"
            elseBody = parseBlock(new String[]{"endif"});
        }
        if (pos < tokens.size() && tokens.get(pos).content.equals("endif")) {
            pos++; // consume "endif"
        }
        return new IfNode(condition, thenBody, elseBody, ifTok.line);
    }
}
