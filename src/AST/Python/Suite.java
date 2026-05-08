package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Suite extends Root {
    List<Stmt> stmts = new ArrayList<>();

    public List<Stmt> getStmts() {
        return stmts;
    }

    public void addStmt(Stmt stmt) {
        this.stmts.add(stmt);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();

        for (Stmt stmt : stmts) {
            sb.append(stmt.toString(level));
        }
        return sb.toString();
    }

}
