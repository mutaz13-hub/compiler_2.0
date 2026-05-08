package AST.Python;

import java.util.List;

public abstract class Root {
    protected String indent(int level) {
        return "  ".repeat(level);
    }

    public abstract String toString(int level);

    @Override
    public String toString() {
        return toString(0);
    }


    protected String listToString(List<? extends Root> nodes, int level) {
        if (nodes == null || nodes.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Root node : nodes) {
            sb.append(node.toString(level)).append("\n");
        }
        return sb.toString();
    }


    protected String nodeToString(Root node, int level) {
        if (node == null) return "";
        return node.toString(level) + "\n";
    }
}
