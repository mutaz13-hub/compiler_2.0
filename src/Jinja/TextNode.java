package Jinja;

import java.util.Map;

/** Raw passthrough text/HTML between Jinja tags. */
public class TextNode extends JinjaNode {
    private final String text;

    public TextNode(String text, int line) {
        this.text = text;
        this.line = line;
    }

    public String getText() { return text; }

    @Override
    public void render(Map<String, Object> context, StringBuilder out) {
        out.append(text);
    }

    @Override
    public void print(int indent) {
        String preview = text.replace("\n", "\\n");
        if (preview.length() > 40) preview = preview.substring(0, 40) + "...";
        System.out.println(pad(indent) + "TEXT (line " + line + "): \"" + preview + "\"");
    }
}
