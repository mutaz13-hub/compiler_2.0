// Generated from C:/Users/Mutaz13/Desktop/compiler_2.0/compiler_2.0/src/HTMLParser.g4 by ANTLR 4.13.2

package antlrHTML;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLParser}.
 */
public interface HTMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(HTMLParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(HTMLParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#html_content}.
	 * @param ctx the parse tree
	 */
	void enterHtml_content(HTMLParser.Html_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#html_content}.
	 * @param ctx the parse tree
	 */
	void exitHtml_content(HTMLParser.Html_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(HTMLParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(HTMLParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#tag_content}.
	 * @param ctx the parse tree
	 */
	void enterTag_content(HTMLParser.Tag_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#tag_content}.
	 * @param ctx the parse tree
	 */
	void exitTag_content(HTMLParser.Tag_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(HTMLParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(HTMLParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(HTMLParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(HTMLParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(HTMLParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(HTMLParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(HTMLParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSelector(HTMLParser.SimpleSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSelector(HTMLParser.SimpleSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#typeSelector}.
	 * @param ctx the parse tree
	 */
	void enterTypeSelector(HTMLParser.TypeSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#typeSelector}.
	 * @param ctx the parse tree
	 */
	void exitTypeSelector(HTMLParser.TypeSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#universal}.
	 * @param ctx the parse tree
	 */
	void enterUniversal(HTMLParser.UniversalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#universal}.
	 * @param ctx the parse tree
	 */
	void exitUniversal(HTMLParser.UniversalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(HTMLParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(HTMLParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attribWithValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 */
	void enterAttribWithValue(HTMLParser.AttribWithValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attribWithValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 */
	void exitAttribWithValue(HTMLParser.AttribWithValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attribWithoutValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 */
	void enterAttribWithoutValue(HTMLParser.AttribWithoutValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attribWithoutValue}
	 * labeled alternative in {@link HTMLParser#attrib}.
	 * @param ctx the parse tree
	 */
	void exitAttribWithoutValue(HTMLParser.AttribWithoutValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code childCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterChildCombinator(HTMLParser.ChildCombinatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitChildCombinator(HTMLParser.ChildCombinatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code adjacentSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterAdjacentSiblingCombinator(HTMLParser.AdjacentSiblingCombinatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code adjacentSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitAdjacentSiblingCombinator(HTMLParser.AdjacentSiblingCombinatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code generalSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterGeneralSiblingCombinator(HTMLParser.GeneralSiblingCombinatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code generalSiblingCombinator}
	 * labeled alternative in {@link HTMLParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitGeneralSiblingCombinator(HTMLParser.GeneralSiblingCombinatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HTMLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 */
	void enterIdentProperty(HTMLParser.IdentPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 */
	void exitIdentProperty(HTMLParser.IdentPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 */
	void enterVarProperty(HTMLParser.VarPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varProperty}
	 * labeled alternative in {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 */
	void exitVarProperty(HTMLParser.VarPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(HTMLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(HTMLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterIdentValue(HTMLParser.IdentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitIdentValue(HTMLParser.IdentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(HTMLParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(HTMLParser.VarValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(HTMLParser.NumberValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(HTMLParser.NumberValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterHashValue(HTMLParser.HashValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitHashValue(HTMLParser.HashValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importantValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterImportantValue(HTMLParser.ImportantValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importantValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitImportantValue(HTMLParser.ImportantValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code urlValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterUrlValue(HTMLParser.UrlValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code urlValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitUrlValue(HTMLParser.UrlValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterParenValue(HTMLParser.ParenValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitParenValue(HTMLParser.ParenValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterCommaValue(HTMLParser.CommaValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitCommaValue(HTMLParser.CommaValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterDotValue(HTMLParser.DotValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitDotValue(HTMLParser.DotValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colonValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterColonValue(HTMLParser.ColonValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colonValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitColonValue(HTMLParser.ColonValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterSlashValue(HTMLParser.SlashValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitSlashValue(HTMLParser.SlashValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterGreaterValue(HTMLParser.GreaterValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitGreaterValue(HTMLParser.GreaterValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterPlusValue(HTMLParser.PlusValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitPlusValue(HTMLParser.PlusValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterMinusValue(HTMLParser.MinusValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitMinusValue(HTMLParser.MinusValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code starValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterStarValue(HTMLParser.StarValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code starValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitStarValue(HTMLParser.StarValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tildeValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterTildeValue(HTMLParser.TildeValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tildeValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitTildeValue(HTMLParser.TildeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalsValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterEqualsValue(HTMLParser.EqualsValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalsValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitEqualsValue(HTMLParser.EqualsValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code questionValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterQuestionValue(HTMLParser.QuestionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code questionValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitQuestionValue(HTMLParser.QuestionValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleQuoteValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuoteValue(HTMLParser.DoubleQuoteValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleQuoteValue}
	 * labeled alternative in {@link HTMLParser#valuePart}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuoteValue(HTMLParser.DoubleQuoteValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#atRule}.
	 * @param ctx the parse tree
	 */
	void enterAtRule(HTMLParser.AtRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#atRule}.
	 * @param ctx the parse tree
	 */
	void exitAtRule(HTMLParser.AtRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atRuleWithBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 */
	void enterAtRuleWithBlock(HTMLParser.AtRuleWithBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atRuleWithBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 */
	void exitAtRuleWithBlock(HTMLParser.AtRuleWithBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atRuleWithoutBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 */
	void enterAtRuleWithoutBlock(HTMLParser.AtRuleWithoutBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atRuleWithoutBlock}
	 * labeled alternative in {@link HTMLParser#atRuleBody}.
	 * @param ctx the parse tree
	 */
	void exitAtRuleWithoutBlock(HTMLParser.AtRuleWithoutBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#jinja2}.
	 * @param ctx the parse tree
	 */
	void enterJinja2(HTMLParser.Jinja2Context ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#jinja2}.
	 * @param ctx the parse tree
	 */
	void exitJinja2(HTMLParser.Jinja2Context ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HTMLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HTMLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(HTMLParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(HTMLParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(HTMLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(HTMLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#expr_content}.
	 * @param ctx the parse tree
	 */
	void enterExpr_content(HTMLParser.Expr_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#expr_content}.
	 * @param ctx the parse tree
	 */
	void exitExpr_content(HTMLParser.Expr_contentContext ctx);
}