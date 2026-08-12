// Generated from CSSParser.g4 by ANTLR 4.13.2
 package antlrCSS; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSSParser}.
 */
public interface CSSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#atRule}.
	 * @param ctx the parse tree
	 */
	void enterAtRule(CSSParser.AtRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#atRule}.
	 * @param ctx the parse tree
	 */
	void exitAtRule(CSSParser.AtRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#rule_}.
	 * @param ctx the parse tree
	 */
	void enterRule_(CSSParser.Rule_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#rule_}.
	 * @param ctx the parse tree
	 */
	void exitRule_(CSSParser.Rule_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void enterSelectorList(CSSParser.SelectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void exitSelectorList(CSSParser.SelectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(CSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(CSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSelector(CSSParser.SimpleSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSelector(CSSParser.SimpleSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void enterSelectorPart(CSSParser.SelectorPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#selectorPart}.
	 * @param ctx the parse tree
	 */
	void exitSelectorPart(CSSParser.SelectorPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#property_}.
	 * @param ctx the parse tree
	 */
	void enterProperty_(CSSParser.Property_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#property_}.
	 * @param ctx the parse tree
	 */
	void exitProperty_(CSSParser.Property_Context ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CSSParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CSSParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CSSParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#block_}.
	 * @param ctx the parse tree
	 */
	void enterBlock_(CSSParser.Block_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#block_}.
	 * @param ctx the parse tree
	 */
	void exitBlock_(CSSParser.Block_Context ctx);
}