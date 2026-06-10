package AST.HTML;

public class HtmlAttributeNode extends Program {

    private String name;
    private String value;

    public HtmlAttributeNode(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(int level) {

        return indent(level)
                + "ATTRIBUTE : "
                + name
                + " = "
                + value
                + "\n";
    }
}