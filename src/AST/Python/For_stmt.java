package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class For_stmt extends Compound_stmt {
     Exprlist targets;
     List<Test> iterables = new ArrayList<>();
     Suite suite;

    public Exprlist getTargets() {
        return targets;
    }

    public void setTargets(Exprlist targets) {
        this.targets = targets;
    }

    public List<Test> getIterables() {
        return iterables;
    }

    public void addIterable(Test t) {
        this.iterables.add(t);
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("For_stmt: for ");
        if (targets != null) sb.append(targets.toString(0));
        sb.append(" in ");
        for (int i = 0; i < iterables.size(); i++) {
            sb.append(iterables.get(i).toString(0));
            if (i < iterables.size() - 1) sb.append(", ");
        }
        if (suite != null) sb.append("\n").append(suite.toString(level + 1));
        return sb.toString();
    }

}
