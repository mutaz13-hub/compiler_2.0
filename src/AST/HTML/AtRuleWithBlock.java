package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class AtRuleWithBlock extends AtRuleBody {

    private List<Rule> rules = new ArrayList<>();
    private List<Declaration> declarations = new ArrayList<>();
    private List<AtRule> atRules = new ArrayList<>();

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void addDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
    }

    public void addAtRule(AtRule atRule) {
        this.atRules.add(atRule);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public List<AtRule> getAtRules() {
        return atRules;
    }

    @Override
    public String toString(int level) {
        return "AtRuleWithBlock{" +
                "rules=" + rules +
                ", declarations=" + declarations +
                ", atRules=" + atRules +
                '}';
    }
}
