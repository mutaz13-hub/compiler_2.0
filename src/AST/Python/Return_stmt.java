package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Return_stmt extends Small_stmt {
    List<Test> values = new ArrayList<>(); // القيم المرجعة

    public List<Test> getValues() {
        return values;
    }

    public void addValue(Test t) {
        this.values.add(t);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder(indent(level)).append("return");
        if (!values.isEmpty()) {
            sb.append(" ");
            for (int i = 0; i < values.size(); i++) {
                sb.append(values.get(i).toString(0));
                if (i < values.size() - 1) sb.append(", ");
            }
        }
        return sb.toString();
    }

}
