package AST.Python;

public class ListAssign extends Assign_part{
     Simple_stmt stmt;

    public Simple_stmt getStmt() {
        return stmt;
    }

    public void setStmt(Simple_stmt stmt) {
        this.stmt = stmt;
    }

    @Override
    public String toString(int level) {

        return stmt != null ? stmt.toString(level) : "";
    }

}
