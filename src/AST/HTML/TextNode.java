package AST.HTML;

public class TextNode extends Program {

    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "TEXT : "
                + text
                + "\n";
    }
}