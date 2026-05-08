package AST.HTML;

public class Declaration extends Style {

     Property property;
     Value value;

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Property getProperty() {
        return property;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString(int level) {
        return indent(level)
                + property.toString(0)
                + " : "
                + value.toString(0)
                + ";";
    }

}
