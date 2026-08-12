package Jinja;

import java.util.Map;

/** A `{{ expression }}` output tag. Supports dotted access, e.g. product.name . */
public class VarNode extends JinjaNode {
    private final String expression;

    public VarNode(String expression, int line) {
        this.expression = expression.trim();
        this.line = line;
    }

    public String getExpression() { return expression; }

    @Override
    public void render(Map<String, Object> context, StringBuilder out) {
        Object value = JinjaEvaluator.resolve(expression, context);
        out.append(value == null ? "" : String.valueOf(value));
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "VAR (line " + line + "): {{ " + expression + " }}");
    }
}
