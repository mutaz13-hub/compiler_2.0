package Jinja;

import java.util.Map;

/** A `{% if condition %} ... {% else %} ... {% endif %}` block. Simple truthiness only. */
public class IfNode extends JinjaNode {
    private final String condition;
    private final JinjaProgram thenBody;
    private final JinjaProgram elseBody; // may be null

    public IfNode(String condition, JinjaProgram thenBody, JinjaProgram elseBody, int line) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
        this.line = line;
    }

    @Override
    public void render(Map<String, Object> context, StringBuilder out) {
        if (JinjaEvaluator.isTruthy(JinjaEvaluator.resolve(condition, context))) {
            thenBody.render(context, out);
        } else if (elseBody != null) {
            elseBody.render(context, out);
        }
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "IF (line " + line + "): " + condition);
        thenBody.print(indent + 1);
        if (elseBody != null) {
            System.out.println(pad(indent) + "ELSE:");
            elseBody.print(indent + 1);
        }
        System.out.println(pad(indent) + "ENDIF");
    }
}
