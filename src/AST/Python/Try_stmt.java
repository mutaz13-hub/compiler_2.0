package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Try_stmt extends Compound_stmt{
     Suite trySuite;
     List<Except_clause> exceptClauses = new ArrayList<>();

    public Suite getTrySuite() {
        return trySuite;
    }

    public void setTrySuite(Suite trySuite) {
        this.trySuite = trySuite;
    }

    public List<Except_clause> getExceptClauses() {
        return exceptClauses;
    }

    public void addExceptClause(Except_clause exc) {
        this.exceptClauses.add(exc);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder(indent(level)).append("try:\n");
        if (trySuite != null) sb.append(trySuite.toString(level + 1)).append("\n");
        for (Except_clause exc : exceptClauses) {
            sb.append(indent(level)).append("except:\n").append(exc.toString(level + 1)).append("\n");
        }
        return sb.toString().trim();
    }

}
