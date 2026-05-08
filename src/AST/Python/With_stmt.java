package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class With_stmt extends Compound_stmt{
    List<With_item> items = new ArrayList<>();
     Suite suite;

    public List<With_item> getItems() {
        return items;
    }

    public void addItem(With_item item) {
        this.items.add(item);
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder(indent(level)).append("with ");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).toString(0));
            if (i < items.size() - 1) sb.append(", ");
        }
        if (suite != null) sb.append(":\n").append(suite.toString(level + 1));
        return sb.toString();
    }

}
