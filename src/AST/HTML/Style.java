package AST.HTML;

public class Style extends Html_content {
    Rule rule;
    AtRule atRule;

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public AtRule getAtRule() {
        return atRule;
    }

    public void setAtRule(AtRule atRule) {
        this.atRule = atRule;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder("Style{");
        if (rule != null) sb.append("rule=").append(rule);
        if (atRule != null) sb.append("atRule=").append(atRule);
        sb.append('}');
        return sb.toString();
    }
}
