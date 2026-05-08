package AST.HTML;

public class ParenValue extends ValuePart {

    private Value value;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString(int level) {
        return "(" + value + ")";
    }
}
