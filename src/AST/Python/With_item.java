package AST.Python;

public class With_item extends With_stmt {
    Test test;
     Expr expr;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Expr getAlias() {
        return expr;
    }

    public void setAlias(Expr alias) {
        this.expr = alias;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        if (test != null) sb.append(test.toString(0));
        if (expr != null) sb.append(" as ").append(expr.toString(0));
        return sb.toString();
    }

}
