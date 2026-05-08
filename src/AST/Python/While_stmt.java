package AST.Python;

public class While_stmt extends Compound_stmt {
     Test condition;
     Suite suite;

    public Test getCondition() {
        return condition;
    }

    public void setCondition(Test condition) {
        this.condition = condition;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder(indent(level)).append("while ");
        if (condition != null) sb.append(condition.toString(0));
        if (suite != null) sb.append(":\n").append(suite.toString(level + 1));
        return sb.toString();
    }

}
