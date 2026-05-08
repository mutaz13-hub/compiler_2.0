package AST.HTML;

public class IdentValue extends ValuePart {

     String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(int level) {
        return name;
    }
}
