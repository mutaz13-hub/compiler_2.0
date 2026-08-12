package AST.CSS;

import java.util.ArrayList;
import java.util.List;

/** A `selector { declarations }` rule block. */
public class CSSRule extends CSSNode {
    private final List<String> selectors = new ArrayList<>();
    private final List<CSSDeclaration> declarations = new ArrayList<>();

    public List<String> getSelectors() { return selectors; }
    public void addSelector(String s) { selectors.add(s); }
    public List<CSSDeclaration> getDeclarations() { return declarations; }
    public void addDeclaration(CSSDeclaration d) { declarations.add(d); }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("RULE (line ").append(line).append("): ")
          .append(String.join(", ", selectors)).append("\n");
        for (CSSDeclaration d : declarations) {
            sb.append(d.toString(level + 1)).append("\n");
        }
        return sb.toString();
    }
}
