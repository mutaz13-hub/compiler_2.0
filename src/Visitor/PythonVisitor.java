    package Visitor;

    import AST.Python.*;
    import AST.Python.Number;
    import antlrPython.*;
import SymbolTable.PythonSymbolTable;

    public class PythonVisitor extends PythonParserBaseVisitor<Object> {
        PythonSymbolTable pythonSymbolTable = new PythonSymbolTable();
        public PythonSymbolTable getSymbolTable() {
            return pythonSymbolTable;
        }
        @Override
        public Program visitRoot(PythonParser.RootContext ctx) {
            Program program = new Program();
            for (PythonParser.StmtContext sctx : ctx.stmt()) {
                program.addStmt((Root) visit(sctx));
            }
            return program;
        }

        @Override
        public Root visitStmt(PythonParser.StmtContext ctx) {
            if (ctx.simple_stmt() != null) {
                return (Stmt) visit(ctx.simple_stmt());
            }
            else if (ctx.compound_stmt() != null) {
                return (Stmt) visit(ctx.compound_stmt());
            }
            else {
                return (Stmt) visit(ctx.decorated());
            }


        }

        @Override
        public Simple_stmt visitSimple_stmt_line(PythonParser.Simple_stmt_lineContext ctx) {
            SimpleStmtLine node = new SimpleStmtLine();
            for (PythonParser.Small_stmtContext sctx : ctx.small_stmt()) {
                node.getSmallStmts().add(
                        (Small_stmt) visit(sctx)
                );
            }
            node.setLine(ctx.getStart().getLine());
            return node;
        }

        @Override
        public Simple_stmt visitSimple_stmt_block(PythonParser.Simple_stmt_blockContext ctx) {
            SimpleStmtBlock node = new SimpleStmtBlock();
            for (PythonParser.Small_stmtContext sctx : ctx.small_stmt()) {
                node.getSmallStmts().add((Small_stmt) visit(sctx));
            }
            node.setLine(ctx.getStart().getLine());
            return node;
        }

        @Override
        public Stmt visitDecorated(PythonParser.DecoratedContext ctx) {
            Decorated node = new Decorated();
            for (PythonParser.DecoratorContext dctx : ctx.decorator()) {
                node.addDecorator((Decorator) visit(dctx));
            }
            node.setCompoundStmt((Compound_stmt) visit(ctx.compound_stmt()));
            node.setLine(ctx.getStart().getLine());
            return node;
        }

        @Override
        public Compound_stmt visitIf_stmt(PythonParser.If_stmtContext ctx) {
            If_stmt node = new If_stmt();
            pythonSymbolTable.enter("if_block");

            if (ctx.IF() != null) {
                node.setKeyword("IF");
            } else if (ctx.ELIF() != null) {
                node.setKeyword("ELIF");
            } else {
                node.setKeyword("ELSE");
            }
            if (ctx.test() != null) {
                node.setCondition((Test) visit(ctx.test()));
            }
            node.setSuite((Suite) visit(ctx.suite())
            );
            node.setLine(ctx.getStart().getLine());

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Compound_stmt visitWhile_stmt(PythonParser.While_stmtContext ctx) {
            While_stmt node = new While_stmt();
            pythonSymbolTable.enter("while_loop");

            node.setCondition((Test) visit(ctx.test()));
            node.setSuite((Suite) visit(ctx.suite()));

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Compound_stmt visitFor_stmt(PythonParser.For_stmtContext ctx) {
            For_stmt node = new For_stmt();
            pythonSymbolTable.enter("for_loop");

            node.setTargets((Exprlist) visit(ctx.exprlist()));
            for (PythonParser.TestContext tctx : ctx.test()) {
                node.addIterable((Test) visit(tctx));
            }
            node.setSuite((Suite) visit(ctx.suite()));

            if (ctx.exprlist() != null) {
                for (PythonParser.ExprContext exprCtx : ctx.exprlist().expr()) {
                    if (exprCtx instanceof PythonParser.AtomExprContext) {
                        PythonParser.AtomContext atomCtx = ((PythonParser.AtomExprContext) exprCtx).atom();
                        if (atomCtx instanceof PythonParser.NameAtomContext) {
                            String varName = ((PythonParser.NameAtomContext) atomCtx).name().getText();
                            pythonSymbolTable.define(varName, "variable", "unknown", varName, ctx.getStart().getLine());
                        }
                    }
                }
            }

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Compound_stmt visitTry_stmt(PythonParser.Try_stmtContext ctx) {
            Try_stmt node = new Try_stmt();
            pythonSymbolTable.enter("try_block");

            node.setTrySuite((Suite) visit(ctx.suite()));
            for (PythonParser.Except_clauseContext ectx : ctx.except_clause()) {
                node.addExceptClause((Except_clause) visit(ectx));
            }

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Compound_stmt visitWith_stmt(PythonParser.With_stmtContext ctx) {
            With_stmt node = new With_stmt();
            pythonSymbolTable.enter("with_block");

            for (PythonParser.With_itemContext wctx : ctx.with_item()) {
                node.addItem((With_item) visit(wctx));
            }
            node.setSuite((Suite) visit(ctx.suite()));

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Compound_stmt visitFunc_def(PythonParser.Func_defContext ctx) {
            Func_def node = new Func_def();
            String funcName = ctx.name(0).getText();
            pythonSymbolTable.define(funcName, "function", "function", "function_definition", ctx.getStart().getLine());
            pythonSymbolTable.enter(funcName);

            node.setName((Name) visit(ctx.name(0)));
            for (int i = 1; i < ctx.name().size(); i++) {
                String paramName = ctx.name(i).getText();
                pythonSymbolTable.define(paramName, "parameter", "unknown", paramName, ctx.getStart().getLine());
                node.addParam((Name) visit(ctx.name(i)));
            }
            if (ctx.ARROW() != null) {
                node.setReturnType((Test) visit(ctx.test()));
            }
            node.setSuite((Suite) visit(ctx.suite()));
            node.setLine(ctx.getStart().getLine());

            pythonSymbolTable.exit();
            return node;
        }

        @Override
        public Root visitSuite(PythonParser.SuiteContext ctx) {
            Suite node = new Suite();
            if (ctx.simple_stmt() != null) {
                node.addStmt((Stmt) visit(ctx.simple_stmt()));
            }
            for (PythonParser.StmtContext sctx : ctx.stmt()) {
                node.addStmt((Stmt) visit(sctx));
            }
            return node;
        }

        @Override
        public Decorated visitDecorator(PythonParser.DecoratorContext ctx) {
            Decorator node = new Decorator();
            for (PythonParser.NameContext nctx : ctx.name()) {
                node.addName((Name) visit(nctx));
            }
            if (ctx.LPAREN() != null) {
                if (ctx.test() != null){
                    for (PythonParser.TestContext tctx : ctx.test()) {
                        node.addArg((Test) visit(tctx));
                    }
                }
            }
            return node;
        }

        @Override
        public With_stmt visitWith_item(PythonParser.With_itemContext ctx) {
            With_item node = new With_item();
            node.setTest((Test) visit(ctx.test()));
            if (ctx.expr() != null) {
                node.setAlias((Expr) visit(ctx.expr()));
            }
            return node;
        }

        @Override
        public Try_stmt visitExcept_clause(PythonParser.Except_clauseContext ctx) {
            Except_clause node = new Except_clause();
            node.setSuite((Suite) visit(ctx.suite()));
            return node;
        }

        @Override
        public For_stmt visitExprlist(PythonParser.ExprlistContext ctx) {
            Exprlist node = new Exprlist();
            for (PythonParser.ExprContext ectx : ctx.expr()) {
                node.addExpr((Expr) visit(ectx));
            }
            return node;
        }

        @Override
        public Small_stmt visitExpr_stmt(PythonParser.Expr_stmtContext ctx) {
            Expr_stmt node = new Expr_stmt();
            node.setLine(ctx.getStart().getLine());
            node.setTest((Test) visit(ctx.test()));
            if (ctx.assign_part() != null) {
                node.setAssignPart((Assign_part) visit(ctx.assign_part()));

                String varName = ctx.test().getText();
                String varValue = ctx.assign_part().getText();

                // Remove leading colon or equals sign and whitespace
                if (varValue.startsWith(":") || varValue.startsWith("=")) {
                    varValue = varValue.substring(1).trim();
                }
                // Handle cases like ": type = value"
                if (varValue.contains("=")) {
                    varValue = varValue.substring(varValue.indexOf("=") + 1).trim();
                }

                pythonSymbolTable.define(varName, "variable", "unknown", varValue, ctx.getStart().getLine());
            }
            return node;
        }

        @Override
        public Small_stmt visitReturn_stmt(PythonParser.Return_stmtContext ctx) {
            Return_stmt node = new Return_stmt();
            node.setLine(ctx.getStart().getLine());
            for (PythonParser.TestContext tctx : ctx.test()) {
                node.addValue((Test) visit(tctx));
            }

            return node;
        }

        @Override
        public Small_stmt visitImport_stmt(PythonParser.Import_stmtContext ctx) {
            Import_stmt node = new Import_stmt();
            node.setLine(ctx.getStart().getLine());
            node.setName((Name) visit(ctx.name()));
            return node;
        }

        @Override
        public Small_stmt visitFrom_stmt(PythonParser.From_stmtContext ctx) {
            From_stmt node = new From_stmt();
            node.setLine(ctx.getStart().getLine());
            node.setModule((Name) visit(ctx.name(0)));
            for (int i = 1; i < ctx.name().size(); i++) {
                node.addImported((Name) visit(ctx.name(i)));
            }
            return node;
        }

        @Override
        public Assign_part visitAnnotatedAssign(PythonParser.AnnotatedAssignContext ctx) {
            AnnotatedAssign node = new AnnotatedAssign();
            node.setTest((Test) visit(ctx.test(0)));
            if (ctx.EQ() != null) {
                for (int i = 1; i < ctx.test().size(); i++) {
                    node.addDefaultValue((Test) visit(ctx.test(i)));
                }
            }
            return node;
        }

        @Override
        public Root visitTest(PythonParser.TestContext ctx) {
            Test node = new Test();
            if (ctx.comparison() != null) {
                node.setComparison((Comparison) visit(ctx.comparison()));
                return node;
            }
            if (ctx.NOT() != null) {
                Test innerTest = (Test) visit(ctx.test(0));
                node.setTest(innerTest);
                node.setOperator(Test.Operator.NOT);
                return node;
            }
            if (ctx.AND() != null) {
                Test left = (Test) visit(ctx.test(0));
                Test right = (Test) visit(ctx.test(1));
                node.setTest(left);
                node.setTest(right);
                node.setOperator(Test.Operator.AND);
                return node;
            }
            if (ctx.OR() != null) {
                Test left = (Test) visit(ctx.test(0));
                Test right = (Test) visit(ctx.test(1));
                node.setTest(left);
                node.setTest(right);
                node.setOperator(Test.Operator.OR);
                return node;
            }
            return null;
        }




        @Override
        public Root visitComparison(PythonParser.ComparisonContext ctx) {
            Comparison node = new Comparison();
            node.setLine(ctx.getStart().getLine());
            node.addExpr((Expr) visit(ctx.expr(0)));
            for (int i = 1; i < ctx.expr().size(); i++) {
                Comparison.CompOp op = null;

                if (ctx.EQUALS(i-1) != null) op = Comparison.CompOp.EQUALS;
                else if (ctx.NOT_EQ_2(i-1) != null) op = Comparison.CompOp.NOT_EQUALS;
                else if (ctx.IN(i-1) != null) {
                    op = (ctx.NOT(i-1) != null) ? Comparison.CompOp.NOT_IN : Comparison.CompOp.IN;
                }
                else if (ctx.IS(i-1) != null) {
                    op = (ctx.NOT(i-1) != null) ? Comparison.CompOp.IS_NOT : Comparison.CompOp.IS;
                }
                else if (ctx.EQ(i-1) != null) {
                    op = Comparison.CompOp.EQ;
                    String varName = ctx.expr(i-1).getText();
                    String varValue = ctx.expr(i).getText();
                    pythonSymbolTable.define(varName, "variable", "unknown", varValue, ctx.getStart().getLine());
                }
                node.addOp(op);
                node.addExpr((Expr) visit(ctx.expr(i)));
            }
            return node;
        }

        @Override
        public Expr visitAtomExpr(PythonParser.AtomExprContext ctx) {
             AtomExpr node = new AtomExpr();
             node.setAtom((Atom) visit(ctx.atom()));
             for (PythonParser.TrailerContext tctx : ctx.trailer()) {
                 node.addTrailer((Trailer) visit(tctx));
             }
             return node;
         }

        @Override
        public Expr visitAdditiveExpr(PythonParser.AdditiveExprContext ctx) {
            AdditiveExpr node = new AdditiveExpr();
            node.setLine(ctx.getStart().getLine());
            node.setLeft((Expr) visit(ctx.expr(0)));
            node.setRight((Expr) visit(ctx.expr(1)));
            if (ctx.PLUS() != null) {
                node.setOp(AdditiveExpr.BinaryOp.PLUS);
            } else if (ctx.MINUS() != null) {
                node.setOp(AdditiveExpr.BinaryOp.MINUS);
            }
            return node;
        }

        @Override
        public Atom visitParenAtom(PythonParser.ParenAtomContext ctx) {
            ParenAtom node = new ParenAtom();
            node.setLine(ctx.getStart().getLine());
            if (ctx.testlist_comp() != null){
                node.setTestlist_comp((Testlist_comp) visit(ctx.testlist_comp()));
            }
            return node;
        }

        @Override
        public Atom visitListAtom(PythonParser.ListAtomContext ctx) {
            ListAtom node = new ListAtom();
            node.setLine(ctx.getStart().getLine());
            if (ctx.testlist_comp() != null) {
                node.setTestlist_comp((Testlist_comp) visit(ctx.testlist_comp()));
            }
            return node;
        }

        @Override
        public Atom visitDictAtom(PythonParser.DictAtomContext ctx) {
            DictAtom node = new DictAtom();
            node.setLine(ctx.getStart().getLine());
            for (PythonParser.DictItemContext ictx : ctx.dictItem()) {
                DictItem item = new DictItem();
                item.setLine(ictx.getStart().getLine());
                String rawKey = ictx.STRING() != null ? ictx.STRING().getText() : ictx.name().getText();

                if (rawKey.length() >= 2 && (rawKey.startsWith("\"") || rawKey.startsWith("'"))) {
                    rawKey = rawKey.substring(1, rawKey.length() - 1);
                }
                item.setKey(rawKey);
                item.setValue((Test) visit(ictx.test()));
                node.addItem(item);
            }
            return node;
        }

        @Override
        public Atom visitNameAtom(PythonParser.NameAtomContext ctx) {
            NameAtom node = new NameAtom();
            node.setLine(ctx.getStart().getLine());
            node.setName((Name) visit(ctx.name()));
            return node;
        }

        @Override
        public Atom visitPrintAtom(PythonParser.PrintAtomContext ctx) {
            PrintAtom node = new PrintAtom();
            node.setLine(ctx.getStart().getLine());
            return node;
        }

        @Override
        public Atom visitNumberAtom(PythonParser.NumberAtomContext ctx) {
            NumberAtom node = new NumberAtom();
            node.setLine(ctx.getStart().getLine());
            node.setNumber((Number) visit(ctx.number()));
            if (ctx.MINUS() != null) {
                node.setNegative(true);
            }
            return node;
        }

        @Override
        public Atom visitNoneAtom(PythonParser.NoneAtomContext ctx) {
            NoneAtom node = new NoneAtom();
            node.setLine(ctx.getStart().getLine());
            return node;
        }

        @Override
        public Atom visitStringAtom(PythonParser.StringAtomContext ctx) {
            StringAtom node = new StringAtom();
            node.setLine(ctx.getStart().getLine());
            for (var str : ctx.STRING()) {
                node.getString().add(str.getText());
            }
            return node;
        }

        @Override
        public Atom visitTestlist_comp(PythonParser.Testlist_compContext ctx) {
            Testlist_comp node = new Testlist_comp();
             node.getTest().add((Test) visit(ctx.test(0))
            );
            for (int i = 1; i < ctx.test().size(); i++) {
                node.getTest().add(
                        (Test) visit(ctx.test(i))
                );
            }
            return node;
        }

        @Override
        public Root visitName(PythonParser.NameContext ctx) {
            Name nameNode = new Name();
            if (ctx.NAME() != null) {
                nameNode.setName(ctx.NAME().getText());
                return nameNode;
            }
            if (ctx.TRUE() != null) {
                nameNode.setTrue_name(ctx.TRUE().getText());
                return nameNode;
            }
            if (ctx.FALSE() != null) {
                nameNode.setFalse_name(ctx.FALSE().getText());
                return nameNode;
            }
            return null;
        }

        @Override
        public Root visitNumber(PythonParser.NumberContext ctx) {
            Number number = new Number();
            if (ctx.DECIMAL_INTEGER() != null) {
                number.setInteger_number(Integer.parseInt(ctx.DECIMAL_INTEGER().getText()));
                return number;
            }
            if (ctx.FLOAT_NUMBER() != null) {
                number.setFloat_number(Float.parseFloat(ctx.FLOAT_NUMBER().getText()));
                return number;
            }
            return null;
        }

        @Override
        public AtomExpr visitTrailer(PythonParser.TrailerContext ctx) {
            Trailer trailer = new Trailer();
            if (ctx.DOT() != null) {
                trailer.setName((Name) visit(ctx.name()));
                return trailer;
            }
            if (ctx.LPAREN() != null) {
                for (PythonParser.TestContext testCtx : ctx.test()) {
                    trailer.setTest((Test) visit(testCtx));
                }
                return trailer;
            }
            return null;
        }
    }
