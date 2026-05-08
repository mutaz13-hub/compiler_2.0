package AST.HTML;
import java.util.ArrayList;
import java.util.List;

public class Stmt extends Statement {

    private List<String> ids = new ArrayList<>();

    public void addId(String id) {
        this.ids.add(id);
    }

    public List<String> getIds() {
        return ids;
    }

    @Override
    public String toString(int level) {
        return "Stmt{" +
                "ids=" + ids +
                '}';
    }
}
