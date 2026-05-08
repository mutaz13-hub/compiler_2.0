package AST.HTML;

public class AttribWithValue extends Attrib {

    private String id;
    private String value;

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString(int level) {
        return "[" + "ID"+ id +"Value"+ value + "]";
    }
}
