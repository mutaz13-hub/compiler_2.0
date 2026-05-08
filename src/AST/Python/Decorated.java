package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Decorated extends Stmt {
     List<Decorator> decorators = new ArrayList<>();
     Compound_stmt compoundStmt;
    int line;
    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }


    public List<Decorator> getDecorators() {
        return decorators;
    }

    public void addDecorator(Decorator decorator) {
        this.decorators.add(decorator);
    }

    public Compound_stmt getCompoundStmt() {
        return compoundStmt;
    }

    public void setCompoundStmt(Compound_stmt compoundStmt) {
        this.compoundStmt = compoundStmt;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("Decorated: ");
        sb.append("line").append(line).append("\n");
        for (Decorator d : decorators) {
            sb.append(d.toString(0)).append(" ");
        }
        if (compoundStmt != null) {
            sb.append("\n").append(compoundStmt.toString(level + 1));
        }
        return sb.toString().trim();
    }

}
