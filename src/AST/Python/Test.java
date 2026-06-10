package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Test extends Root {
    public enum Operator {
        NONE, NOT, AND, OR
    }
    ArrayList<Test>test;
    Comparison comparison;
    Operator operator = Operator.NONE;

    public List<Test> getTests() { return test; }
    public Comparison getComparison() { return comparison; }
    public Operator getOperator() { return operator; }
    public void setOperator(Operator operator) { this.operator = operator; }

    public Test() {
        this.test = new ArrayList<>();
    }

    public void setTest(Test test) {
        this.test.add(test);
    }

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    @Override
    public String toString(int level) {
        if (comparison != null) return comparison.toString(0);
        if (!test.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            if (operator == Operator.NOT) sb.append("not ");
            for (int i = 0; i < test.size(); i++) {
                sb.append(test.get(i).toString(0));
                if (i < test.size() - 1) {
                    sb.append(" ").append(operator.name().toLowerCase()).append(" ");
                }
            }
            return sb.toString();
        }
        return "";
    }

}
