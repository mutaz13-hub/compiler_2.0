package AST.HTML;

public class CDataNode extends Program {

    private String content;

    public CDataNode(String content) {
        this.content = content;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "CDATA : "
                + content
                + "\n";
    }
}