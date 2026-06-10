package SymbolTable;

import java.util.*;

public class PythonSymbolTable {

    static class Scope {
        Scope parent;
        String name;
        Map<String, SymbolInfo> symbols = new HashMap<>();
        List<Scope> children = new ArrayList<>();

        Scope(Scope parent, String name) {
            this.parent = parent;
            this.name = name;
        }

        void define(String name, SymbolInfo info){
            symbols.put(name, info);
        }

        boolean resolve(String name){
            if(symbols.containsKey(name)) return true;
            return parent != null && parent.resolve(name);
        }

        SymbolInfo lookup(String name) {
            if (symbols.containsKey(name)) return symbols.get(name);
            return parent != null ? parent.lookup(name) : null;
        }
    }

    Scope root = new Scope(null, "global");
    Scope current = root;

    public void enter(String name){
        Scope newScope = new Scope(current, name);
        if (current != null) {
            current.children.add(newScope);
        }
        current = newScope;
    }

    public void exit(){
        if (current.parent != null) {
            current = current.parent;
        }
    }

    public void define(String name, String type, String dataType, String value, int line){
        current.define(name, new SymbolInfo(type, dataType, value, line));
    }

    public boolean exists(String name){
        return current.resolve(name);
    }

    public boolean existsAnywhere(String name) {
        return findScopeWithSymbol(root, name) != null;
    }

    private Scope findScopeWithSymbol(Scope scope, String name) {
        if (scope.symbols.containsKey(name)) return scope;
        for (Scope child : scope.children) {
            Scope found = findScopeWithSymbol(child, name);
            if (found != null) return found;
        }
        return null;
    }

    public SymbolInfo lookup(String name) {
        return current.lookup(name);
    }

    public void printTable() {
        System.out.println("\nPython Symbol Table:");
        printScope(root, 0);
    }

    private void printScope(Scope scope, int indent) {
        String indentStr = "  ".repeat(indent);
        System.out.println(indentStr + "Scope: " + scope.name);
        
        if (!scope.symbols.isEmpty()) {
            String tableIndent = indentStr + "  ";
            System.out.println(tableIndent + "+----------------------+----------------------+----------------------+-------+");
            System.out.println(tableIndent + "| Name                 | Type                 | Value                | Line  |");
            System.out.println(tableIndent + "+----------------------+----------------------+----------------------+-------+");
            
            for (Map.Entry<String, SymbolInfo> entry : scope.symbols.entrySet()) {
                SymbolInfo info = entry.getValue();
                System.out.printf("%s| %-20s | %-20s | %-20s | %-5d |\n",
                        tableIndent,
                        truncate(entry.getKey(), 20),
                        truncate(info.getType(), 20),
                        truncate(info.getValue(), 20),
                        info.getLine());
            }
            System.out.println(tableIndent + "+----------------------+----------------------+----------------------+-------+");
        }

        for (Scope child : scope.children) {
            printScope(child, indent + 1);
        }
    }

    private String truncate(String str, int length) {
        if (str.length() <= length) return str;
        return str.substring(0, length - 3) + "...";
    }
}
