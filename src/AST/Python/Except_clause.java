package AST.Python;

public class Except_clause extends Try_stmt{
    Suite suite;

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("Except_clause:\n");
        if (suite != null) sb.append(suite.toString(level + 1));
        return sb.toString().trim();
    }

}
