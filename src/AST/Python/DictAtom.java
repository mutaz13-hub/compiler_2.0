package AST.Python;

import java.util.ArrayList;
import java.util.List;

/**
 * A dict literal atom, e.g. {"name": "Phone", "price": 300}.
 * Extends Atom like NumberAtom/StringAtom/ListAtom (OOP inheritance +
 * polymorphism: all atoms are interchangeable wherever an Atom is expected).
 */
public class DictAtom extends Atom {
    private List<DictItem> items = new ArrayList<>();

    public List<DictItem> getItems() { return items; }
    public void addItem(DictItem item) { items.add(item); }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).toString(0));
            if (i < items.size() - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
