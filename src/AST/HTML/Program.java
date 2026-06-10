package AST.HTML;

public abstract class Program {
    protected int line;

    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }

    protected String indent(int level) {
        return "    ".repeat(level);
    }

    public abstract String toString(int level);

    @Override
    public String toString() {
        return toString(0);
    }
}