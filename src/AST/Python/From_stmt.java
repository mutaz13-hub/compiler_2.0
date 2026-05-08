package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class From_stmt extends Small_stmt {
     Name module;
     List<Name> imported = new ArrayList<>();

    public Name getModule() { return module; }
    public void setModule(Name module) { this.module = module; }

    public List<Name> getImported() { return imported; }
    public void addImported(Name n) { this.imported.add(n); }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("from ").append(module != null ? module.toString(1) : "");
        if (!imported.isEmpty()) {
            sb.append(" import ");
            for (int i = 0; i < imported.size(); i++) {
                sb.append(imported.get(i).toString(0));
                if (i < imported.size() - 1) sb.append(", ");
            }
        }
        return sb.toString();
    }

}
