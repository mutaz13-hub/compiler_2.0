package AST.HTML;

public class Id extends ValuePart {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(int level) {
        return id == null ? "" : id;
    }
}
