package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Program extends Root {
    List<Root> stmts = new ArrayList<>();


    public List<Root> getStmts() {
        return stmts;
    }

    public void addStmt(Root stmt) {
        this.stmts.add(stmt);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("Program {\n");

        for (Root node : stmts) {
            sb.append(indent(level + 1));
            sb.append(node.toString(0));
            sb.append("\n");
        }
        sb.append(indent(level)).append("}");
        return sb.toString();
    }

}
