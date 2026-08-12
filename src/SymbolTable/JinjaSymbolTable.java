package SymbolTable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A scoped symbol table for a Jinja template, built while the semantic
 * analyzer walks the Jinja AST. The "global" scope is whatever top-level
 * data was passed in from Python (e.g. `products`); each `{% for %}` block
 * pushes a new scope that additionally knows its own loop variable, mirroring
 * how the Python symbol table handles function scopes elsewhere in this
 * project.
 */
public class JinjaSymbolTable {

    private static class Scope {
        final Scope parent;
        final String name;
        final Map<String, String> vars = new LinkedHashMap<>(); // name -> kind (e.g. "data", "loop-var")
        final java.util.List<Scope> children = new java.util.ArrayList<>();
        Scope(Scope parent, String name) { this.parent = parent; this.name = name; }
    }

    private final Scope root = new Scope(null, "template");
    private Scope current = root;

    public void enter(String name) {
        Scope child = new Scope(current, name);
        current.children.add(child);
        current = child;
    }
    public void exit() { if (current.parent != null) current = current.parent; }

    public void define(String name, String kind) {
        current.vars.put(name, kind);
    }

    /** Does `name` resolve in the current scope chain (including parents)? */
    public boolean exists(String name) {
        Scope s = current;
        while (s != null) {
            if (s.vars.containsKey(name)) return true;
            s = s.parent;
        }
        return false;
    }

    public void printTable() {
        System.out.println("\nJinja Symbol Table:");
        printScope(root, 0);
    }

    private void printScope(Scope scope, int indent) {
        String pad = "  ".repeat(indent);
        System.out.println(pad + "Scope: " + scope.name);
        for (Map.Entry<String, String> e : scope.vars.entrySet()) {
            System.out.println(pad + "  " + e.getKey() + " : " + e.getValue());
        }
        for (Scope child : scope.children) {
            printScope(child, indent + 1);
        }
    }
}
