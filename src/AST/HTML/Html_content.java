package AST.HTML;

public class Html_content extends Root {
    Tag tag;
    Style style;
    Jinja2 jinja2;
    int line;

    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Jinja2 getJinja2() {
        return jinja2;
    }

    public void setJinja2(Jinja2 jinja2) {
        this.jinja2 = jinja2;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent(level)).append("Html_content {").append("line =").append(line).append("\n");

        if (tag != null) {
            sb.append(indent(level + 1))
                    .append("tag:\n")
                    .append(tag.toString(level + 2))
                    .append("\n");
        }

        if (style != null) {
            sb.append(indent(level + 1))
                    .append("style:\n")
                    .append(style.toString(level + 2))
                    .append("\n");
        }

        if (jinja2 != null) {
            sb.append(indent(level + 1))
                    .append("jinja2:\n")
                    .append(jinja2.toString(level + 2))
                    .append("\n");
        }

        sb.append(indent(level)).append("}");

        return sb.toString();
    }
}
