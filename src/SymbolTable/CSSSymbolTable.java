package SymbolTable;

import AST.CSS.CSSProgram;
import AST.CSS.CSSRule;
import AST.CSS.CSSDeclaration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple symbol table for CSS: maps each selector to the set of
 * (property -> value) declarations defined for it, in the same spirit as
 * the Python/HTML symbol tables elsewhere in this project (build the
 * table while walking the tree, then print it in a readable form).
 */
public class CSSSymbolTable {
    private final Map<String, Map<String, String>> selectorsToProps = new LinkedHashMap<>();

    public void build(CSSProgram program) {
        for (CSSRule rule : program.getRules()) {
            for (String selector : rule.getSelectors()) {
                Map<String, String> props = selectorsToProps.computeIfAbsent(selector.trim(), k -> new LinkedHashMap<>());
                for (CSSDeclaration d : rule.getDeclarations()) {
                    props.put(d.getProperty(), d.getValue());
                }
            }
        }
    }

    public void printTable() {
        System.out.println("\nCSS Symbol Table:");
        for (Map.Entry<String, Map<String, String>> e : selectorsToProps.entrySet()) {
            System.out.println("  Selector: " + e.getKey());
            for (Map.Entry<String, String> p : e.getValue().entrySet()) {
                System.out.println("    " + p.getKey() + ": " + p.getValue());
            }
        }
    }
}
