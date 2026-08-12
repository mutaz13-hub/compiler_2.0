package AST.Python;

/**
 * A single "key: value" entry inside a dict literal, e.g. "name": "Phone".
 * Part of the Python AST added to support real dict literals
 * (products = [{"name": "Phone", "price": 300}, ...]).
 */
public class DictItem extends Root {
    private String key;
    private Test value;

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public Test getValue() { return value; }
    public void setValue(Test value) { this.value = value; }

    @Override
    public String toString(int level) {
        return "\"" + key + "\": " + (value != null ? value.toString(0) : "");
    }
}
