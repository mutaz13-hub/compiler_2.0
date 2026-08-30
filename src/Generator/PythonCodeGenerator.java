package Generator;

import AST.Python.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;



public class PythonCodeGenerator {
    private final StringWriter stringWriter = new StringWriter();
    private final PrintWriter emit = new PrintWriter(stringWriter);
    private int indentLevel = 0;

   
   
    public void generate(Program program) {
        if (program == null || program.getStmts() == null) {
            throw new IllegalArgumentException("شجرة الـ AST فارغة! لا يمكن توليد الكود.");
        }

        emit.println("# الكود المتولد تلقائياً بواسطة المترجم ;)");
        emit.println();

        for (Root stmt : program.getStmts()) {
            emitNode(stmt);
        }
    }

    private void emitNode(Root node) {
        if (node == null) return;
        System.out.println("Generator visiting: " + node.getClass().getName());

        if (node instanceof Simple_stmt) {
            emitSimpleStmt((Simple_stmt) node);
        } else if (node instanceof Func_def) {
            emitFuncDef((Func_def) node);
        } else if (node instanceof If_stmt) {
            emitIfStmt((If_stmt) node);
        } else if (node instanceof While_stmt) {
            emitWhileStmt((While_stmt) node);
        } else if (node instanceof For_stmt) {
            emitForStmt((For_stmt) node);
        } else if (node instanceof Import_stmt) {
            emitImportStmt((Import_stmt) node);
        } else if (node instanceof From_stmt) {
            emitFromStmt((From_stmt) node);
        } else if (node instanceof Suite) {
            emitSuite((Suite) node);
        } else if (node instanceof Expr_stmt) {
            emitExprStmt((Expr_stmt) node);
        } else if (node instanceof Return_stmt) {
            emitReturnStmt((Return_stmt) node);
        } else if (node instanceof Decorator) {
            emitDecorator((Decorator) node);
        } else if (node instanceof Decorated) {
            emitDecorated((Decorated) node);
        } else {
           
            printIndent();
            emit.println("# Unknown node: " + node.getClass().getSimpleName());
            printIndent();
            emit.println(node.toString(0).trim());
        }
    }

    private void emitSimpleStmt(Simple_stmt node) {
        List<Small_stmt> smallStmts = null;
        if (node instanceof SimpleStmtLine) {
            smallStmts = ((SimpleStmtLine) node).getSmallStmts();
        } else if (node instanceof SimpleStmtBlock) {
            smallStmts = ((SimpleStmtBlock) node).getSmallStmts();
        }
        if (smallStmts != null) {
            for (Small_stmt small : smallStmts) {
                printIndent();
                emitSmallStmt(small);
                emit.println();
            }
        }
    }

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            emit.print("    ");
        }
    }

    private void emitSmallStmt(Small_stmt node) {
        if (node instanceof Expr_stmt) {
            emitExprStmt((Expr_stmt) node);
        } else if (node instanceof Return_stmt) {
            emitReturnStmt((Return_stmt) node);
        } else if (node instanceof Import_stmt) {
            emitImportStmt((Import_stmt) node);
        } else if (node instanceof From_stmt) {
            emitFromStmt((From_stmt) node);
        }
    }

    private void emitExprStmt(Expr_stmt node) {
        if (node.getTest() == null) {
            emit.print("# Error: Test is null in Expr_stmt");
            return;
        }
        emitExpr(node.getTest());
        if (node.getAssignPart() != null) {
            emit.print(" = ");
            emitAssignPart(node.getAssignPart());
        }
    }

    private void emitAssignPart(Assign_part node) {
        if (node instanceof AnnotatedAssign) {
            AnnotatedAssign aa = (AnnotatedAssign) node;
            if (aa.getTest() != null) {
                emit.print(": ");
                emitExpr(aa.getTest());
            }
            if (!aa.getDefaultValues().isEmpty()) {
                emit.print(" = ");
                for (int i = 0; i < aa.getDefaultValues().size(); i++) {
                    emitExpr(aa.getDefaultValues().get(i));
                    if (i < aa.getDefaultValues().size() - 1) emit.print(", ");
                }
            }
        } else if (node instanceof ListAssign) {
            ListAssign la = (ListAssign) node;
            emit.print(" = [");
            emitNode(la.getStmt());
            emit.print("]");
        } else if (node instanceof BlockAssign) {
            BlockAssign ba = (BlockAssign) node;
            emit.print(" = {");
            emit.println();
            indentLevel++;
            for (Small_stmt s : ba.getSmall_stmt()) {
                printIndent();
                emitSmallStmt(s);
                emit.println(",");
            }
            indentLevel--;
            printIndent();
            emit.print("}");
        }
    }

    private void emitFuncDef(Func_def node) {
        printIndent();
        emit.print("def ");
        emit.print(getRawName(node.getName()));
        emit.print("(");
        List<Name> params = node.getParams();
        for (int i = 0; i < params.size(); i++) {
            emit.print(params.get(i).getRawName());
            if (i < params.size() - 1) emit.print(", ");
        }
        emit.print(")");
        if (node.getReturnType() != null) {
            emit.print(" -> ");
            emitExpr(node.getReturnType());
        }
        emit.println(":");
        indentLevel++;
        emitSuite(node.getSuite());
        indentLevel--;
        emit.println();
    }

    private void emitIfStmt(If_stmt node) {
        printIndent();
        String keyword = node.getKeyword() != null ? node.getKeyword().toLowerCase() : "if";
        emit.print(keyword);
        if (node.getCondition() != null) {
            emit.print(" ");
            emitExpr(node.getCondition());
        }
        emit.println(":");
        indentLevel++;
        emitSuite(node.getSuite());
        indentLevel--;
    }

    private void emitWhileStmt(While_stmt node) {
        printIndent();
        emit.print("while ");
        emitExpr(node.getCondition());
        emit.println(":");
        indentLevel++;
        emitSuite(node.getSuite());
        indentLevel--;
    }

    private void emitForStmt(For_stmt node) {
        printIndent();
        emit.print("for ");
        if (node.getTargets() != null) {
            emitExpr(node.getTargets());
        } else {
            emit.print("item");
        }
        emit.print(" in ");
        List<Test> iterables = node.getIterables();
        if (iterables != null && !iterables.isEmpty()) {
            for (int i = 0; i < iterables.size(); i++) {
                emitExpr(iterables.get(i));
                if (i < iterables.size() - 1) emit.print(", ");
            }
        } else {
            emit.print("iterable");
        }
        emit.println(":");
        indentLevel++;
        emitSuite(node.getSuite());
        indentLevel--;
    }

    private void emitSuite(Suite node) {
        if (node.getStmts().isEmpty()) {
            printIndent();
            emit.println("pass");
        } else {
            for (Root stmt : node.getStmts()) {
                emitNode(stmt);
            }
        }
    }

    private void emitReturnStmt(Return_stmt node) {
        emit.print("return ");
        List<Test> values = node.getValues();
        for (int i = 0; i < values.size(); i++) {
            emitExpr(values.get(i));
            if (i < values.size() - 1) emit.print(", ");
        }
    }

    private void emitImportStmt(Import_stmt node) {
        emit.print("import ");
        emit.print(getRawName(node.getName()));
    }

    private void emitFromStmt(From_stmt node) {
        emit.print("from ");
        emit.print(getRawName(node.getModule()));
        emit.print(" import ");
        List<Name> imported = node.getImported();
        for (int i = 0; i < imported.size(); i++) {
            emit.print(imported.get(i).getRawName());
            if (i < imported.size() - 1) emit.print(", ");
        }
    }

    private void emitDecorator(Decorator node) {
        printIndent();
        emit.print("@");
        List<Name> names = node.getNames();
        for (int i = 0; i < names.size(); i++) {
            emit.print(names.get(i).getRawName());
            if (i < names.size() - 1) emit.print(".");
        }
        if (node.getArgs() != null && !node.getArgs().isEmpty()) {
            emit.print("(");
            List<Test> args = node.getArgs();
            for (int i = 0; i < args.size(); i++) {
                emitExpr(args.get(i));
                if (i < args.size() - 1) emit.print(", ");
            }
            emit.print(")");
        }
        emit.println();
    }

    private void emitDecorated(Decorated node) {
        if (node.getDecorators() != null) {
            for (Decorator d : node.getDecorators()) {
                emitDecorator(d);
            }
        }
        if (node.getCompoundStmt() != null) {
            emitNode(node.getCompoundStmt());
        }
    }

    private void emitExpr(Root node) {
        if (node == null) return;
        
        if (node instanceof NumberAtom) {
            NumberAtom n = (NumberAtom) node;
            if (n.isNegative()) emit.print("-");
            emit.print(n.toString(0).trim());
        } else if (node instanceof StringAtom) {
            List<String> strings = ((StringAtom) node).getString();
            for (int i = 0; i < strings.size(); i++) {
                emit.print(strings.get(i));
                if (i < strings.size() - 1) emit.print(" ");
            }
        } else if (node instanceof NameAtom) {
            emit.print(((NameAtom) node).getName().getRawName());
        } else if (node instanceof PrintAtom) {
            emit.print("print");
        } else if (node instanceof NoneAtom) {
            emit.print("None");
        } else if (node instanceof ListAtom) {
            
            
            emit.print("[");
            Testlist_comp tc = ((ListAtom) node).getTestlist_comp();
            if (tc != null) emitExpr(tc);
            emit.print("]");
        } else if (node instanceof Testlist_comp) {
            List<Test> items = ((Testlist_comp) node).getTest();
            for (int i = 0; i < items.size(); i++) {
                emitExpr(items.get(i));
                if (i < items.size() - 1) emit.print(", ");
            }
        } else if (node instanceof DictAtom) {
            List<DictItem> items = ((DictAtom) node).getItems();
            emit.print("{");
            for (int i = 0; i < items.size(); i++) {
                emit.print("\"" + items.get(i).getKey() + "\": ");
                emitExpr(items.get(i).getValue());
                if (i < items.size() - 1) emit.print(", ");
            }
            emit.print("}");
        } else if (node instanceof AtomExpr) {
            AtomExpr ae = (AtomExpr) node;
            emitExpr(ae.getAtom());
            for (Trailer t : ae.getTrailers()) {
                emitTrailer(t);
            }
        } else if (node instanceof AdditiveExpr) {
            AdditiveExpr add = (AdditiveExpr) node;
            emitExpr(add.getLeft());
            emit.print(" " + (add.getOp() == AdditiveExpr.BinaryOp.PLUS ? "+" : "-") + " ");
            emitExpr(add.getRight());
        } else if (node instanceof Comparison) {
            
            
            List<Expr> exprs = c.getExprs();
            List<Comparison.CompOp> ops = c.getOps();
            for (int i = 0; i < exprs.size(); i++) {
                emitExpr(exprs.get(i));
                if (i < ops.size()) {
                    emit.print(" " + getOpStr(ops.get(i)) + " ");
                }
            }
        } else if (node instanceof Test) {
            Test t = (Test) node;
            if (t.getComparison() != null) {
                emitExpr(t.getComparison());
            } else if (!t.getTests().isEmpty()) {
                if (t.getOperator() == Test.Operator.NOT) {
                    emit.print("not ");
                }
                List<Test> tests = t.getTests();
                for (int i = 0; i < tests.size(); i++) {
                    emitExpr(tests.get(i));
                    if (i < tests.size() - 1) {
                        if (t.getOperator() != Test.Operator.NONE) {
                            emit.print(" " + t.getOperator().name().toLowerCase() + " ");
                        } else {
                            emit.print(", ");
                        }
                    }
                }
            }
        } else if (node instanceof Exprlist) {
            Exprlist el = (Exprlist) node;
            List<Expr> exprs = el.getExprs();
            for (int i = 0; i < exprs.size(); i++) {
                emitExpr(exprs.get(i));
                if (i < exprs.size() - 1) emit.print(", ");
            }
        } else if (node instanceof Name) {
            emit.print(((Name) node).getRawName());
        } else {
            // Fallback for complex expressions
            emit.print(node.toString(0).trim());
        }
    }

    private void emitTrailer(Trailer t) {
        if (t.getTests() != null && !t.getTests().isEmpty()) {
            emit.print("(");
            List<Test> tests = t.getTests();
            for (int i = 0; i < tests.size(); i++) {
                emitExpr(tests.get(i));
                if (i < tests.size() - 1) emit.print(", ");
            }
            emit.print(")");
        } else if (t.getName() != null) {
            emit.print(".");
            emit.print(t.getName().getRawName());
        } else if (t.getTests() != null) {
            // Empty call
            emit.print("()");
        }
    }

    private String getOpStr(Comparison.CompOp op) {
        switch (op) {
            case EQ: return "=";
            case EQUALS: return "==";
            case NOT_EQUALS: return "!=";
            case LESS: return "<";
            case GREATER: return ">";
            case LESS_EQ: return "<=";
            case GREATER_EQ: return ">=";
            case IN: return "in";
            case NOT_IN: return "not in";
            case IS: return "is";
            case IS_NOT: return "is not";
            default: return "??";
        }
    }

    private String getRawName(Root node) {
        if (node instanceof Name) return ((Name) node).getRawName();
        if (node instanceof NameAtom) return ((NameAtom) node).getName().getRawName();
        return node.toString(0).trim();
    }

    public String getGeneratedCode() {
        return stringWriter.toString();
    }
}
