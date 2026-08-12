package Interpreter;

import AST.Python.*;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bridges the Python AST to the Jinja rendering step.
 *
 * This is the concrete implementation of "the Generator must pass data from
 * the Python data array to the Jinja2 tree" from the project requirements,
 * and stands in for the "Python Bytecode -> Python Virtual Machine
 * (generation of variables and values)" stage of the pipeline diagram.
 *
 * NOTE on scope: this is a literal/constant evaluator, not a real bytecode
 * VM - it walks the already-built Python AST and evaluates top-level
 * `name = <literal>` assignments (numbers, strings, None, list literals,
 * dict literals - including arbitrarily nested combinations of those) into
 * plain Java objects. It deliberately does NOT execute arbitrary Python
 * (function calls, I/O, control flow) - Flask apps read live request data,
 * so "running" app.py for real isn't meaningful here anyway. What matters
 * for the Jinja step is exactly the kind of literal data array your
 * teammate's example shows (products = [{"name": "Phone", "price": 300}]).
 */
public class PythonDataExtractor {

    private final Map<String, Object> globals = new LinkedHashMap<>();

    public Map<String, Object> getGlobals() {
        return globals;
    }

    /** Walks every top-level statement in the program looking for literal assignments. */
    public void extract(Program program) {
        if (program == null || program.getStmts() == null) return;
        for (Root stmt : program.getStmts()) {
            extractFromStmt(stmt);
        }
    }

    private void extractFromStmt(Root node) {
        if (node == null) return;

        if (node instanceof SimpleStmtLine) {
            for (Small_stmt s : ((SimpleStmtLine) node).getSmallStmts()) {
                extractFromStmt(s);
            }
        } else if (node instanceof Expr_stmt) {
            tryExtractAssignment(((Expr_stmt) node).getTest());
        }
        // Anything else (imports, function defs, control flow, Flask routes)
        // is intentionally left alone - see class-level note above.
    }

    /**
     * A plain `name = value` assignment is parsed as a Comparison with the
     * EQ operator (see PythonParser.g4's `comparison` rule) rather than
     * through assign_part, so we look for that shape here.
     */
    private void tryExtractAssignment(Test test) {
        if (test == null) return;
        Comparison comparison = test.getComparison();
        if (comparison == null) return;

        List<Expr> exprs = comparison.getExprs();
        List<Comparison.CompOp> ops = comparison.getOps();
        if (exprs.size() < 2 || ops.isEmpty() || ops.get(0) != Comparison.CompOp.EQ) return;

        String varName = rawNameOf(exprs.get(0));
        if (varName == null) return;

        Object value = evalLiteral(exprs.get(1));
        if (value != NOT_A_LITERAL) {
            globals.put(varName, value);
        }
    }

    // Sentinel for "this expression isn't a literal we can evaluate"
    private static final Object NOT_A_LITERAL = new Object();

    private Object evalLiteral(Root node) {
        if (node == null) return NOT_A_LITERAL;

        // NOTE: every concrete Atom subclass (NumberAtom, StringAtom, ListAtom,
        // DictAtom, ...) extends Atom, and Atom extends AtomExpr - the same
        // inheritance quirk that bit code generation earlier in this project.
        // A bare Atom instance (e.g. a ListAtom recursed into directly, as
        // opposed to the AtomExpr *wrapper* the grammar normally produces
        // around it) still passes `instanceof AtomExpr`, so all the concrete
        // atom checks below MUST run before the generic AtomExpr check, or
        // they get silently swallowed by it (reading its inherited-but-unset
        // `atom`/`trailers` fields and returning nothing).
        if (node instanceof NumberAtom) {
            NumberAtom n = (NumberAtom) node;
            if (n.getNumber() == null) return NOT_A_LITERAL;
            AST.Python.Number num = n.getNumber();
            Object raw = (num.getFloat_number() != 0f) ? (Object) (double) num.getFloat_number()
                                                          : (Object) (long) num.getInteger_number();
            if (raw instanceof Long) return n.isNegative() ? -((Long) raw) : (Long) raw;
            return n.isNegative() ? -((Double) raw) : (Double) raw;
        }
        if (node instanceof StringAtom) {
            StringBuilder sb = new StringBuilder();
            for (String s : ((StringAtom) node).getString()) {
                sb.append(stripQuotes(s));
            }
            return sb.toString();
        }
        if (node instanceof NoneAtom) {
            return null;
        }
        if (node instanceof NameAtom) {
            // Grammar quirk: True/False are parsed as Name (via `name: NAME
            // | TRUE | FALSE`), not as a dedicated boolean atom the way None
            // has its own NoneAtom/NONE token - so they need to be
            // special-cased here, or a literal like `show_banner = True`
            // silently vanishes instead of becoming a real boolean.
            Name n = ((NameAtom) node).getName();
            if (n != null) {
                if (n.getTrue_name() != null) return Boolean.TRUE;
                if (n.getFalse_name() != null) return Boolean.FALSE;
            }
            return NOT_A_LITERAL;
        }
        if (node instanceof ListAtom) {
            List<Object> list = new ArrayList<>();
            Testlist_comp tc = ((ListAtom) node).getTestlist_comp();
            if (tc != null) {
                for (Test t : tc.getTest()) {
                    Object v = evalLiteral(t);
                    if (v == NOT_A_LITERAL) return NOT_A_LITERAL;
                    list.add(v);
                }
            }
            return list;
        }
        if (node instanceof DictAtom) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (DictItem item : ((DictAtom) node).getItems()) {
                Object v = evalLiteral(item.getValue());
                if (v == NOT_A_LITERAL) return NOT_A_LITERAL;
                map.put(item.getKey(), v);
            }
            return map;
        }
        if (node instanceof AtomExpr) {
            AtomExpr ae = (AtomExpr) node;
            // Only bare atoms (no trailers like .foo or (...)) are literals.
            if (!ae.getTrailers().isEmpty()) return NOT_A_LITERAL;
            return evalLiteral(ae.getAtom());
        }
        if (node instanceof Comparison) {
            // NOTE: Comparison extends Test - same footgun as elsewhere in
            // this project (PythonCodeGenerator.emitExpr had the identical
            // bug). This check MUST come before the `instanceof Test` check
            // below, or every Comparison gets swallowed by it.
            Comparison c = (Comparison) node;
            // A bare literal has no comparison operators applied to it.
            if (c.getOps().isEmpty() && c.getExprs().size() == 1) {
                return evalLiteral(c.getExprs().get(0));
            }
            return NOT_A_LITERAL;
        }
        if (node instanceof Test) {
            Test t = (Test) node;
            if (t.getComparison() != null) return evalLiteral(t.getComparison());
            return NOT_A_LITERAL;
        }
        return NOT_A_LITERAL;
    }

    private String stripQuotes(String s) {
        if (s.length() >= 2 && (s.startsWith("\"") || s.startsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    private String rawNameOf(Root node) {
        if (node instanceof Name) return ((Name) node).getRawName();
        if (node instanceof NameAtom) {
            Name n = ((NameAtom) node).getName();
            return n != null ? n.getRawName() : null;
        }
        if (node instanceof AtomExpr) {
            AtomExpr ae = (AtomExpr) node;
            if (!ae.getTrailers().isEmpty()) return null;
            return rawNameOf(ae.getAtom());
        }
        return null;
    }
}
