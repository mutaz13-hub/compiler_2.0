package AST.HTML;

public abstract class Root {
    protected String indent(int level) {
        return "  ".repeat(level);
    }
    public abstract String toString(int level);

    @Override
    public String toString() {
        return toString(0);
    }
}
