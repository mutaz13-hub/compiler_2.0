package AST.HTML;

public class CommentNode extends Program {

    private String text;

    public CommentNode(String text) {
        this.text = text;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "COMMENT : "
                + text
                + "\n";
    }
}