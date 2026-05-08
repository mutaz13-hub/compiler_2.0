package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class BlockAssign extends Assign_part{
    List<Small_stmt> small_stmt= new ArrayList<>();

    public List<Small_stmt> getSmall_stmt() {
        return small_stmt;
    }

    public void setSmall_stmt(List<Small_stmt> small_stmt) {
        this.small_stmt = small_stmt;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("BlockAssign:\n");
        for (Small_stmt stmt : small_stmt) {
            sb.append(stmt.toString(level + 1)).append("\n");
        }
        return sb.toString().trim();
    }

}
