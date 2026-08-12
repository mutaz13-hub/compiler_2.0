package AST.CSS;

/** A single `property: value;` pair inside a rule. */
public class CSSDeclaration extends CSSNode {
    private String property;
    private String value;

    public String getProperty() { return property; }
    public void setProperty(String property) { this.property = property; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @Override
    public String toString(int level) {
        return indent(level) + "DECLARATION (line " + line + "): " + property + ": " + value + ";";
    }
}
