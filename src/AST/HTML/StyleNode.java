package AST.HTML;

public class StyleNode extends HtmlElementNode {

    private String body;

    public StyleNode(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "STYLE\n"
                + indent(level + 1)
                + body
                + "\n";
    }
}