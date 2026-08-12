package AST.CSS;

/** Base class for the CSS AST - same OOP convention as the Python/HTML/Jinja trees. */
public abstract class CSSNode {
    protected int line;
    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }
    public abstract String toString(int level);
    protected String indent(int level) { return "  ".repeat(level); }
    @Override public String toString() { return toString(0); }
}
