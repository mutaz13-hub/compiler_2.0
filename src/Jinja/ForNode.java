package Jinja;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A `{% for x in iterable %} ... {% else %} ... {% endfor %}` block.
 * The `{% else %}` branch (if present) renders when the iterable is
 * empty or missing - matching real Jinja2 semantics and the exact
 * pattern used in test/products.html ("No Products" fallback).
 */
public class ForNode extends JinjaNode {
    private final String loopVar;
    private final String iterableExpr;
    private final JinjaProgram body;
    private final JinjaProgram elseBody; // may be null

    public ForNode(String loopVar, String iterableExpr, JinjaProgram body, JinjaProgram elseBody, int line) {
        this.loopVar = loopVar;
        this.iterableExpr = iterableExpr;
        this.body = body;
        this.elseBody = elseBody;
        this.line = line;
    }

    public String getLoopVar() { return loopVar; }
    public String getIterableExpr() { return iterableExpr; }
    public JinjaProgram getBody() { return body; }
    public JinjaProgram getElseBody() { return elseBody; }

    @SuppressWarnings("unchecked")
    @Override
    public void render(Map<String, Object> context, StringBuilder out) {
        Object iterableObj = JinjaEvaluator.resolve(iterableExpr, context);
        List<Object> items = (iterableObj instanceof List) ? (List<Object>) iterableObj : null;

        if (items == null || items.isEmpty()) {
            if (elseBody != null) elseBody.render(context, out);
            return;
        }
        for (Object item : items) {
            Map<String, Object> loopContext = new HashMap<>(context);
            loopContext.put(loopVar, item);
            body.render(loopContext, out);
        }
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "FOR (line " + line + "): " + loopVar + " in " + iterableExpr);
        body.print(indent + 1);
        if (elseBody != null) {
            System.out.println(pad(indent) + "ELSE:");
            elseBody.print(indent + 1);
        }
        System.out.println(pad(indent) + "ENDFOR");
    }
}
