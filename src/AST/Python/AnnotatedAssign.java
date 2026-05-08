package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class AnnotatedAssign extends Assign_part {
    Test test;
    List<Test> defaultValues = new ArrayList<>();

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Test> getDefaultValues() { return defaultValues; }

    public void addDefaultValue(Test t) { this.defaultValues.add(t); }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("AnnotatedAssign: ");

        if (test != null) sb.append(test.toString(0));
        if (!defaultValues.isEmpty()) {
            sb.append(" = ");
            for (int i = 0; i < defaultValues.size(); i++) {
                sb.append(defaultValues.get(i).toString(0));
                if (i < defaultValues.size() - 1) sb.append(", ");
            }
        }
        return sb.toString();
    }

}
