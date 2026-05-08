package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class SimpleStmtBlock extends Simple_stmt {
    List<Small_stmt> smallStmts = new ArrayList<>();
    int line;
    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }

    public List<Small_stmt> getSmallStmts() {
        return smallStmts;
    }

    public void setSmallStmts(List<Small_stmt> smallStmts) {
        this.smallStmts = smallStmts;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("line").append(line).append("\n");
        for (int i = 0; i < smallStmts.size(); i++) {
            sb.append(smallStmts.get(i).toString(level + 1));
            if (i < smallStmts.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }

}
