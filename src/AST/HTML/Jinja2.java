package AST.HTML;

public class Jinja2 extends Html_content {
    Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public String toString(int level) {
        return "Jinja2{" +
                "statement=" + statement +
                '}';
    }
}
