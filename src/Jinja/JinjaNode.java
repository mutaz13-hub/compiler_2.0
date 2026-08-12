package Jinja;

import java.util.Map;

/**
 * Base class for the Jinja2 AST - the second AST required by the project
 * spec (the first being the Python AST under AST/Python).
 *
 * Follows the same OOP conventions the Python/HTML AST use elsewhere in
 * this project: every node knows its own source line, and rendering is
 * done through polymorphic dispatch (render()) rather than a big
 * instanceof chain, and printing is done through polymorphic dispatch
 * (print()) as well - each concrete subclass knows how to print itself
 * and its own children.
 */
public abstract class JinjaNode {
    protected int line;

    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }

    /** Renders this node (and its children) into `out`, resolving variables against `context`. */
    public abstract void render(Map<String, Object> context, StringBuilder out);

    /** Prints this node and its children in a readable, indented form (project requirement #7). */
    public abstract void print(int indent);

    protected String pad(int indent) {
        return "  ".repeat(indent);
    }
}
