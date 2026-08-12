package AST.CSS;

import java.util.ArrayList;
import java.util.List;

/** Root node of the CSS AST - an ordered list of rules. */
public class CSSProgram extends CSSNode {
    private final List<CSSRule> rules = new ArrayList<>();

    public List<CSSRule> getRules() { return rules; }
    public void addRule(CSSRule r) { rules.add(r); }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder(indent(level) + "CSS_PROGRAM\n");
        for (CSSRule r : rules) sb.append(r.toString(level + 1));
        return sb.toString();
    }
}
