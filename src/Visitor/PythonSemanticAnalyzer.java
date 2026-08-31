package Visitor;

import AST.Python.*;
import SymbolTable.*;
import java.util.ArrayList;
import java.util.List;

public class PythonSemanticAnalyzer {
    private PythonSymbolTable symbolTable = new PythonSymbolTable();
    private List<SemanticError> errors = new ArrayList<>();
    private boolean flaskImported = false;

    public List<SemanticError> getErrors() {
        return errors;
    }

    public void analyze(Program program) {
        for (Root stmt : program.getStmts()) {
            analyzeNode(stmt);
        }
        
        if (flaskImported) {
            checkFlaskVariables();
        }
    }

    private void analyzeNode(Root node) {
        if (node == null) return;
        if (node instanceof NameAtom) {
            checkUndefinedVariables(node);
        } else if (node instanceof Expr_stmt) {
            Expr_stmt exprStmt = (Expr_stmt) node;
            if (exprStmt.getAssignPart() != null) {
                String varName = getRawName(exprStmt.getTest());
                String rightType = "unknown";
                
                if (exprStmt.getAssignPart() instanceof AnnotatedAssign) {
                    AnnotatedAssign aa = (AnnotatedAssign) exprStmt.getAssignPart();
                    for (Test t : aa.getDefaultValues()) {
                        analyzeNode(t);
                        rightType = inferType(t);
                    }
                } else if (exprStmt.getAssignPart() instanceof BlockAssign) {
                    BlockAssign ba = (BlockAssign) exprStmt.getAssignPart();
                    for (Small_stmt ss : ba.getSmall_stmt()) {
                        analyzeNode(ss);
                    }
                    rightType = "object";
                }
                
                checkAssignment(varName, rightType, exprStmt.getLine());
                symbolTable.define(varName, "variable", rightType, varName, exprStmt.getLine());
            } else {
                analyzeNode(exprStmt.getTest());
            }
        } else if (node instanceof Import_stmt) {
            Import_stmt imp = (Import_stmt) node;
            String name = getRawName(imp.getName());
            if (name.equals("flask")) flaskImported = true;
            symbolTable.define(name, "module", "module", name, imp.getLine());
        } else if (node instanceof From_stmt) {
            From_stmt from = (From_stmt) node;
            String module = getRawName(from.getModule());
            if (module.equals("flask")) flaskImported = true;
            for (Name imported : from.getImported()) {
                String impName = imported.getRawName();
                symbolTable.define(impName, "variable", "unknown", impName, from.getLine());
            }
        } else if (node instanceof Func_def) {
            Func_def func = (Func_def) node;
            String funcName = getRawName(func.getName());
            symbolTable.define(funcName, "function", "function", "def", func.getLine());
            symbolTable.enter(funcName);
            for (Name param : func.getParams()) {
                String paramName = param.getRawName();
                symbolTable.define(paramName, "parameter", "unknown", "param", func.getLine());
            }
            analyzeNode(func.getSuite());
            symbolTable.exit();
        } else if (node instanceof If_stmt) {
            If_stmt ifStmt = (If_stmt) node;
            symbolTable.enter("if_block");
            if (ifStmt.getCondition() != null) analyzeNode(ifStmt.getCondition());
            analyzeNode(ifStmt.getSuite());
            symbolTable.exit();
        } else if (node instanceof While_stmt) {
            While_stmt whileStmt = (While_stmt) node;
            symbolTable.enter("while_loop");
            analyzeNode(whileStmt.getCondition());
            analyzeNode(whileStmt.getSuite());
            symbolTable.exit();
        } else if (node instanceof For_stmt) {
            For_stmt forStmt = (For_stmt) node;
            symbolTable.enter("for_loop");

            analyzeNode(forStmt.getSuite());
            symbolTable.exit();
        } else if (node instanceof With_stmt) {

            With_stmt withStmt = (With_stmt) node;
            for (With_item item : withStmt.getItems()) {
                if (item.getTest() != null) analyzeNode(item.getTest());
                if (item.getAlias() != null) {
                    String aliasName = getRawName(item.getAlias());
                    symbolTable.define(aliasName, "variable", "unknown", aliasName, node.getLine());
                }
            }
            analyzeNode(withStmt.getSuite());
        } else if (node instanceof Suite) {
            Suite suite = (Suite) node;
            for (Root stmt : suite.getStmts()) {
                analyzeNode(stmt);
            }
        } else if (node instanceof SimpleStmtLine) {
            SimpleStmtLine line = (SimpleStmtLine) node;
            for (Small_stmt small : line.getSmallStmts()) {
                analyzeNode(small);
            }
        } else if (node instanceof Comparison) {
            Comparison comp = (Comparison) node;
            List<Expr> exprs = comp.getExprs();
            List<Comparison.CompOp> ops = comp.getOps();
            
            for (int i = 0; i < exprs.size(); i++) {
                if (i < ops.size() && ops.get(i) == Comparison.CompOp.EQ) {
                    String varName = getRawName(exprs.get(i));
                    String rightType = (i + 1 < exprs.size()) ? inferType(exprs.get(i+1)) : "unknown";
                    checkAssignment(varName, rightType, comp.getLine());
                    symbolTable.define(varName, "variable", rightType, varName, comp.getLine());
                } else if (i > 0 && ops.get(i-1) == Comparison.CompOp.EQ) {

                    analyzeNode(exprs.get(i));
                } else {
                    analyzeNode(exprs.get(i));
                }
            }
        } else if (node instanceof Test) {
            Test t = (Test) node;
            if (t.getComparison() != null) analyzeNode(t.getComparison());
            for (Test inner : t.getTests()) {
                analyzeNode(inner);
            }
        } else if (node instanceof Trailer) {
            Trailer t = (Trailer) node;
            for (Test test : t.getTests()) {
                analyzeNode(test);
            }
        } else if (node instanceof AtomExpr) {
            AtomExpr atomExpr = (AtomExpr) node;
            analyzeNode(atomExpr.getAtom());
            for (Trailer t : atomExpr.getTrailers()) {
                if (t.getTests() != null) {
                    for (Test test : t.getTests()) {
                        analyzeNode(test);
                    }
                }
            }
        } else if (node instanceof AdditiveExpr) {
            AdditiveExpr add = (AdditiveExpr) node;
            analyzeNode(add.getLeft());
            analyzeNode(add.getRight());
            String leftType = inferType(add.getLeft());
            String rightType = inferType(add.getRight());
            if (!leftType.equals("unknown") && !rightType.equals("unknown") && !leftType.equals(rightType)) {
                errors.add(new SemanticError(SemanticError.ErrorType.TYPE_ERROR, 
                    "Type error: Cannot perform addition between " + leftType + " and " + rightType, add.getLine()));
            }
        } else if (node instanceof Return_stmt) {
            Return_stmt ret = (Return_stmt) node;
            for (Test t : ret.getValues()) {
                analyzeNode(t);
            }
        }

    }

    private String getRawName(Root node) {
        if (node == null) return "unknown";
        if (node instanceof Name) return ((Name) node).getRawName();
        if (node instanceof NameAtom) {
            NameAtom na = (NameAtom) node;
            return na.getName() != null ? na.getName().getRawName() : "unknown";
        }
        if (node instanceof Test) {
            Test t = (Test) node;
            return getRawName(t.getComparison());
        }
        if (node instanceof Comparison) {
            Comparison c = (Comparison) node;
            if (!c.getExprs().isEmpty()) return getRawName(c.getExprs().get(0));
        }
        if (node instanceof AtomExpr) {
            return getRawName(((AtomExpr) node).getAtom());
        }
        try {
            return node.toString(0).trim();
        } catch (Exception e) {
            return "unknown";
        }
    }

    private String inferType(Root node) {
        if (node instanceof NumberAtom) return "number";
        if (node instanceof StringAtom) return "string";
        if (node instanceof NoneAtom) return "None";
        if (node instanceof NameAtom) {
            String name = getRawName(node);
            SymbolInfo info = symbolTable.lookup(name);
            return info != null ? info.getDataType() : "unknown";
        }
        if (node instanceof AdditiveExpr) {
            String left = inferType(((AdditiveExpr) node).getLeft());
            String right = inferType(((AdditiveExpr) node).getRight());
            if (left.equals(right)) return left;
            return "unknown";
        }
        if (node instanceof AtomExpr) {
            return inferType(((AtomExpr) node).getAtom());
        }
        if (node instanceof Test) {
            Test t = (Test) node;
            if (t.getComparison() != null) return inferType(t.getComparison());
            if (!t.getTests().isEmpty()) return "bool"; // for NOT, AND, OR
        }
        if (node instanceof Comparison) {
            Comparison c = (Comparison) node;
            if (c.getOps().isEmpty() && !c.getExprs().isEmpty()) {
                return inferType(c.getExprs().get(0));
            }
            return "bool";
        }
        return "unknown";
    }

    private void checkAssignment(String name, String newType, int line) {
        SymbolInfo existing = symbolTable.lookup(name);
        if (existing != null) {
            if (!existing.getDataType().equals("unknown") && !newType.equals("unknown") && !existing.getDataType().equals(newType)) {
                errors.add(new SemanticError(SemanticError.ErrorType.TYPE_MISMATCHED, 
                    "Type mismatched: Variable '" + name + "' already has type " + existing.getDataType() + ", cannot assign " + newType, line));
            }
        }
    }

    private void checkUndefinedVariables(Root node) {
        if (node == null) return;
        
        if (node instanceof NameAtom) {
            String name = getRawName(node);
            if (!symbolTable.exists(name) && !isBuiltin(name)) {
                if (symbolTable.existsAnywhere(name)) {
                    errors.add(new SemanticError(SemanticError.ErrorType.SCOPE_ERROR, 
                        "Scope error: Variable '" + name + "' exists in another scope but is not accessible here", node.getLine()));
                } else {
                    errors.add(new SemanticError(SemanticError.ErrorType.UNDEFINED_VARIABLE, 
                        "Undefined variable: '" + name + "'", node.getLine()));
                }
            }
        } else if (node instanceof AdditiveExpr) {
            checkUndefinedVariables(((AdditiveExpr) node).getLeft());
            checkUndefinedVariables(((AdditiveExpr) node).getRight());
        } else if (node instanceof AtomExpr) {
            checkUndefinedVariables(((AtomExpr) node).getAtom());
            for (Trailer t : ((AtomExpr) node).getTrailers()) {
                if (t.getTests() != null) {
                    for (Test test : t.getTests()) {
                        checkUndefinedVariables(test);
                    }
                }
            }
        } else if (node instanceof Test) {
            Test t = (Test) node;
            if (t.getComparison() != null) checkUndefinedVariables(t.getComparison());
            for (Test inner : t.getTests()) {
                checkUndefinedVariables(inner);
            }
        } else if (node instanceof Comparison) {
            for (Expr e : ((Comparison) node).getExprs()) {
                checkUndefinedVariables(e);
            }
        }
    }

    private boolean isBuiltin(String name) {
        return name.equals("print") || name.equals("len") || name.equals("range") ||
               name.equals("int") || name.equals("float") || name.equals("str") ||
               name.equals("__name__") || name.equals("None") || name.equals("True") || name.equals("False") ||
               name.equals("max") || name.equals("min") || name.equals("sum") || name.equals("sorted") ||
               name.equals("list") || name.equals("dict") || name.equals("set") || name.equals("tuple") ||
               name.equals("enumerate") || name.equals("zip") || name.equals("bool") || name.equals("abs") ||
               name.equals("open") || name.equals("round") || name.equals("isinstance") || name.equals("type");
    }

    private void checkFlaskVariables() {
        String[] required = {"APP", "request"};
        for (String var : required) {
            if (!symbolTable.exists(var)) {
                errors.add(new SemanticError(SemanticError.ErrorType.MISSING_FLASK_VARIABLE, 
                    "Missing flask variable: '" + var + "' is required when using Flask", 0));
            }
        }
    }
}
