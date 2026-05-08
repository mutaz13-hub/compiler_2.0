// Generated from C:/Users/Mutaz13/Desktop/compiler_2.0/compiler_2.0/src/HTMLParser.g4 by ANTLR 4.13.2

package antlrHTML;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(HTMLParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#html_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml_content(HTMLParser.Html_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(HTMLParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#tag_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag_content(HTMLParser.Tag_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(HTMLParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(HTMLParser.StyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(HTMLParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#simpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSelector(HTMLParser.SimpleSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#typeSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSelector(HTMLParser.TypeSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#universal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversal(HTMLParser.UniversalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(HTMLParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribWithValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribWithValue(HTMLParser.AttribWithValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribWithoutValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribWithoutValue(HTMLParser.AttribWithoutValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code childCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildCombinator(HTMLParser.ChildCombinatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code adjacentSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjacentSiblingCombinator(HTMLParser.AdjacentSiblingCombinatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generalSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralSiblingCombinator(HTMLParser.GeneralSiblingCombinatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentProperty(HTMLParser.IdentPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarProperty(HTMLParser.VarPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(HTMLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentValue(HTMLParser.IdentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarValue(HTMLParser.VarValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(HTMLParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashValue(HTMLParser.HashValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importantValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportantValue(HTMLParser.ImportantValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code urlValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrlValue(HTMLParser.UrlValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenValue(HTMLParser.ParenValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaValue(HTMLParser.CommaValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotValue(HTMLParser.DotValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colonValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColonValue(HTMLParser.ColonValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashValue(HTMLParser.SlashValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterValue(HTMLParser.GreaterValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusValue(HTMLParser.PlusValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusValue(HTMLParser.MinusValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code starValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarValue(HTMLParser.StarValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tildeValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTildeValue(HTMLParser.TildeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalsValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsValue(HTMLParser.EqualsValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code questionValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionValue(HTMLParser.QuestionValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteValue(HTMLParser.DoubleQuoteValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#atRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtRule(HTMLParser.AtRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atRuleWithBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtRuleWithBlock(HTMLParser.AtRuleWithBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atRuleWithoutBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtRuleWithoutBlock(HTMLParser.AtRuleWithoutBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#jinja2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2(HTMLParser.Jinja2Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HTMLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(HTMLParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(HTMLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#expr_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_content(HTMLParser.Expr_contentContext ctx);
}