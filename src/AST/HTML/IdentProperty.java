package AST.HTML;

public class IdentProperty extends Property{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(int level) {
        return "";
    }
}
