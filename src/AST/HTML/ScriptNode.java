package AST.HTML;

public class ScriptNode extends HtmlElementNode {

    private String body;

    public ScriptNode(String body) {
        this.body = body;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "SCRIPT\n"
                + indent(level + 1)
                + body
                + "\n";
    }
}