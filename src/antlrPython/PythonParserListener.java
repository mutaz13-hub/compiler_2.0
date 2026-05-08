// Generated from D:/Study/مواد/مترجمات 1/مشروع/compilerProjectGithub/compiler_project/src/PythonParser.g4 by ANTLR 4.13.2

package antlrPython;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(PythonParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(PythonParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PythonParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PythonParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple_stmt_line}
	 * labeled alternative in {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt_line(PythonParser.Simple_stmt_lineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple_stmt_line}
	 * labeled alternative in {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt_line(PythonParser.Simple_stmt_lineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple_stmt_block}
	 * labeled alternative in {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt_block(PythonParser.Simple_stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple_stmt_block}
	 * labeled alternative in {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt_block(PythonParser.Simple_stmt_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorated}.
	 * @param ctx the parse tree
	 */
	void enterDecorated(PythonParser.DecoratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorated}.
	 * @param ctx the parse tree
	 */
	void exitDecorated(PythonParser.DecoratedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code try_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTry_stmt(PythonParser.Try_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code try_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTry_stmt(PythonParser.Try_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWith_stmt(PythonParser.With_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with_stmt}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWith_stmt(PythonParser.With_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code func_def}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by the {@code func_def}
	 * labeled alternative in {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(PythonParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(PythonParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#with_item}.
	 * @param ctx the parse tree
	 */
	void enterWith_item(PythonParser.With_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#with_item}.
	 * @param ctx the parse tree
	 */
	void exitWith_item(PythonParser.With_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void enterExcept_clause(PythonParser.Except_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void exitExcept_clause(PythonParser.Except_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(PythonParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(PythonParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code import_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code import_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code from_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFrom_stmt(PythonParser.From_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code from_stmt}
	 * labeled alternative in {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFrom_stmt(PythonParser.From_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code annotatedAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedAssign(PythonParser.AnnotatedAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code annotatedAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedAssign(PythonParser.AnnotatedAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void enterListAssign(PythonParser.ListAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void exitListAssign(PythonParser.ListAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void enterBlockAssign(PythonParser.BlockAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockAssign}
	 * labeled alternative in {@link PythonParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void exitBlockAssign(PythonParser.BlockAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(PythonParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(PythonParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(PythonParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(PythonParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(PythonParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(PythonParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenAtom(PythonParser.ParenAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenAtom(PythonParser.ParenAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListAtom(PythonParser.ListAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListAtom(PythonParser.ListAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNameAtom(PythonParser.NameAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNameAtom(PythonParser.NameAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterPrintAtom(PythonParser.PrintAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitPrintAtom(PythonParser.PrintAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(PythonParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(PythonParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNoneAtom(PythonParser.NoneAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNoneAtom(PythonParser.NoneAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(PythonParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(PythonParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#testlist_comp}.
	 * @param ctx the parse tree
	 */
	void enterTestlist_comp(PythonParser.Testlist_compContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#testlist_comp}.
	 * @param ctx the parse tree
	 */
	void exitTestlist_comp(PythonParser.Testlist_compContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PythonParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PythonParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PythonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PythonParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailer(PythonParser.TrailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailer(PythonParser.TrailerContext ctx);
}