package Visitor;

import Jinja.*;
import SymbolTable.JinjaSymbolTable;
import SymbolTable.SemanticError;
import java.util.*;

/**
 * Semantic analysis for the Jinja AST, walked against the data map that
 * PythonDataExtractor produced from the Python side - this is exactly
 * where "the generator passes Python data into the Jinja tree" becomes
 * checkable, not just renderable: real values from the Python side (not
 * just names) are used to catch real mistakes. Implements five semantic
 * error types, mirroring the five required on the Python side:
 *
 *   1) UNDEFINED_TEMPLATE_VARIABLE - {{ x }} / {% if x %} / {% for _ in x %}
 *      references a base name that isn't in scope (neither passed-in data
 *      nor an enclosing loop variable).
 *   2) FOR_NOT_ITERABLE - {% for x in y %} where y is a *known* top-level
 *      data key whose actual extracted value isn't a list (e.g. a string
 *      or number) - checked against real data, not just a name guess.
 *   3) INVALID_ATTRIBUTE_ACCESS - `product.price` where `product` is a
 *      loop variable over real list-of-dict data, but `price` never
 *      appears as a key on any dict in that list.
 *   4) EMPTY_LOOP_BODY - a {% for %} whose body has no VarNode / nested
 *      for / nested if / non-blank text at all - a near-certain mistake.
 *   5) DUPLICATE_LOOP_VARIABLE - a nested {% for %} reusing the same loop
 *      variable name as an enclosing {% for %}, silently shadowing it.
 */
public class JinjaSemanticAnalyzer {
    private final JinjaSymbolTable symbolTable = new JinjaSymbolTable();
    private final List<SemanticError> errors = new ArrayList<>();

    /** loop-variable name -> set of dict keys seen across the list it iterates */
    private final Map<String, Set<String>> loopVarShapes = new HashMap<>();
    /** currently active loop-variable names, innermost last (for shadowing checks) */
    private final Deque<String> activeLoopVars = new ArrayDeque<>();

    private Map<String, Object> data;

    public JinjaSymbolTable getSymbolTable() { return symbolTable; }
    public List<SemanticError> getErrors() { return errors; }

    public void analyze(JinjaProgram program, Map<String, Object> data) {
        this.data = data;
        for (String key : data.keySet()) {
            symbolTable.define(key, "data");
        }
        walk(program);
    }

    private void walk(JinjaProgram program) {
        if (program == null) return;
        for (JinjaNode node : program.getChildren()) walk(node);
    }

    @SuppressWarnings("unchecked")
    private void walk(JinjaNode node) {
        if (node == null) return;

        if (node instanceof TextNode) {
            return;
        }

        if (node instanceof VarNode) {
            checkExpression(((VarNode) node).getExpression(), node.getLine());
            return;
        }

        if (node instanceof ForNode) {
            ForNode f = (ForNode) node;
            String loopVar = f.getLoopVar();
            String iterableExpr = f.getIterableExpr();

            checkExpression(iterableExpr, f.getLine());

            // Check 2: FOR_NOT_ITERABLE - only checkable when the iterable
            // is a plain top-level data name (e.g. "products"), since that's
            // the only case we have a concrete value for.
            if (!iterableExpr.contains(".") && data.containsKey(iterableExpr)) {
                Object value = data.get(iterableExpr);
                if (!(value instanceof List)) {
                    errors.add(new SemanticError(SemanticError.ErrorType.FOR_NOT_ITERABLE,
                            "'" + iterableExpr + "' is not a list, cannot be used in a for loop", f.getLine()));
                } else {
                    // Record the loop variable's dict "shape" (union of keys
                    // across all items) so attribute access inside the loop
                    // body can be checked against real data.
                    Set<String> keys = new HashSet<>();
                    for (Object item : (List<Object>) value) {
                        if (item instanceof Map) keys.addAll(((Map<String, Object>) item).keySet());
                    }
                    if (!keys.isEmpty()) loopVarShapes.put(loopVar, keys);
                }
            }

            // Check 4: EMPTY_LOOP_BODY
            if (isBodyEmpty(f.getBody())) {
                errors.add(new SemanticError(SemanticError.ErrorType.EMPTY_LOOP_BODY,
                        "for loop over '" + iterableExpr + "' has an empty body", f.getLine()));
            }

            // Check 5: DUPLICATE_LOOP_VARIABLE
            if (activeLoopVars.contains(loopVar)) {
                errors.add(new SemanticError(SemanticError.ErrorType.DUPLICATE_LOOP_VARIABLE,
                        "loop variable '" + loopVar + "' shadows an enclosing for loop's variable of the same name",
                        f.getLine()));
            }

            symbolTable.enter("for:" + loopVar);
            symbolTable.define(loopVar, "loop-var");
            activeLoopVars.push(loopVar);
            walk(f.getBody());
            activeLoopVars.pop();
            loopVarShapes.remove(loopVar);
            symbolTable.exit();

            if (f.getElseBody() != null) walk(f.getElseBody());
            return;
        }

        if (node instanceof IfNode) {
            IfNode i = (IfNode) node;
            checkExpression(i.getCondition(), i.getLine());
            symbolTable.enter("if");
            walk(i.getThenBody());
            symbolTable.exit();
            if (i.getElseBody() != null) {
                symbolTable.enter("else");
                walk(i.getElseBody());
                symbolTable.exit();
            }
        }
    }

    private boolean isBodyEmpty(JinjaProgram body) {
        if (body == null || body.getChildren().isEmpty()) return true;
        for (JinjaNode child : body.getChildren()) {
            if (child instanceof VarNode || child instanceof ForNode || child instanceof IfNode) return false;
            if (child instanceof TextNode && !((TextNode) child).getText().trim().isEmpty()) return false;
        }
        return true;
    }

    /** Checks both the base name (Check 1) and, for `x.attr`, the attribute against known shape (Check 3). */
    private void checkExpression(String expression, int line) {
        if (expression == null || expression.trim().isEmpty()) return;
        String[] parts = expression.trim().split("\\.");
        String base = parts[0];

        if (!symbolTable.exists(base)) {
            errors.add(new SemanticError(SemanticError.ErrorType.UNDEFINED_TEMPLATE_VARIABLE,
                    "Undefined template variable: '" + base + "'", line));
            return;
        }

        if (parts.length > 1 && loopVarShapes.containsKey(base)) {
            String attr = parts[1];
            if (!loopVarShapes.get(base).contains(attr)) {
                errors.add(new SemanticError(SemanticError.ErrorType.INVALID_ATTRIBUTE_ACCESS,
                        "'" + base + "' has no attribute '" + attr + "' in the data passed from Python", line));
            }
        }
    }
}
