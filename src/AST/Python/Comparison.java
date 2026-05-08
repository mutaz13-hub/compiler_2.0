package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Comparison extends Test{
    public enum CompOp {
        EQUALS,
        NOT_EQUALS,
        IN,
        NOT_IN,
        IS,
        IS_NOT,
        EQ
    }
    List<CompOp> ops = new ArrayList<>();
    List<Expr> expr = new ArrayList<>();

    public void addExpr(Expr e) {
        expr.add(e);
    }

    public void addOp(CompOp op) {
        ops.add(op);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expr.size(); i++) {
            sb.append(expr.get(i).toString(0));
            if (i < ops.size()) {
                sb.append(" ").append(ops.get(i)).append(" ");
            }
        }
        return sb.toString();
    }

}
