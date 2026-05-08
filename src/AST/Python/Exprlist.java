package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Exprlist extends For_stmt{
    List<Expr> exprs = new ArrayList<>();

    public List<Expr> getExprs() {
        return exprs;
    }

    public void addExpr(Expr e) {
        this.exprs.add(e);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exprs.size(); i++) {
            sb.append(exprs.get(i).toString(0));
            if (i < exprs.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

}
