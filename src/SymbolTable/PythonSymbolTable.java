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

    public void define(String name, String type, String value, int line){
        current.define(name, new SymbolInfo(type, value, line));
    }

    public boolean exists(String name){
        return current.resolve(name);
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

    public String getSymbolTableAsHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><head><title>Python Symbol Table</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f7f6; color: #333; margin: 20px; }");
        htmlBuilder.append("h1 { color: #2c3e50; text-align: center; }");
        htmlBuilder.append(".scope { background: #fff; border: 1px solid #ddd; border-radius: 8px; margin-bottom: 20px; padding: 15px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
        htmlBuilder.append(".scope-name { font-size: 1.2em; font-weight: bold; color: #2980b9; border-bottom: 2px solid #eee; padding-bottom: 5px; margin-bottom: 10px; }");
        htmlBuilder.append("table { width: 100%; border-collapse: collapse; margin-top: 10px; }");
        htmlBuilder.append("th, td { text-align: left; padding: 10px; border-bottom: 1px solid #eee; }");
        htmlBuilder.append("th { background-color: #f8f9fa; color: #666; font-weight: 600; text-transform: uppercase; font-size: 0.85em; }");
        htmlBuilder.append("tr:hover { background-color: #f1f1f1; }");
        htmlBuilder.append("</style>");
        htmlBuilder.append("</head><body>");
        htmlBuilder.append("<h1>Python Symbol Table</h1>");
        htmlBuilder.append(getScopeAsHtml(root, 0));
        htmlBuilder.append("</body></html>");
        return htmlBuilder.toString();
    }

    private String getScopeAsHtml(Scope scope, int indent) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(String.format("<div class=\"scope\" style=\"margin-left: %dpx;\">", indent * 30));
        htmlBuilder.append(String.format("<div class=\"scope-name\">Scope: %s</div>", scope.name));
        
        if (!scope.symbols.isEmpty()) {
            htmlBuilder.append("<table>");
            htmlBuilder.append("<thead><tr><th>Name</th><th>Type</th><th>Value</th><th>Line</th></tr></thead>");
            htmlBuilder.append("<tbody>");
            for (Map.Entry<String, SymbolInfo> entry : scope.symbols.entrySet()) {
                SymbolInfo info = entry.getValue();
                htmlBuilder.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%d</td></tr>",
                        entry.getKey(), info.getType(), info.getValue(), info.getLine()));
            }
            htmlBuilder.append("</tbody></table>");
        }

        for (Scope child : scope.children) {
            htmlBuilder.append(getScopeAsHtml(child, indent + 1));
        }
        htmlBuilder.append("</div>");
        return htmlBuilder.toString();
    }
}
