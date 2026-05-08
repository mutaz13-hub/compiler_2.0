package AST.Python;

public class AdditiveExpr extends Expr {
    public enum BinaryOp {
        PLUS,
        MINUS
    }

    Expr left;
    Expr right;
    BinaryOp op;

    public void setLeft(Expr left) {
        this.left = left;
    }

    public void setRight(Expr right) {
        this.right = right;
    }

    public void setOp(BinaryOp op) {
        this.op = op;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("AdditiveExpr: ");

        if (left != null) sb.append(left.toString(0));
        if (op != null) sb.append(" ").append(op);
        if (right != null) sb.append(" ").append(right.toString(0));

        return sb.toString();
    }
}
