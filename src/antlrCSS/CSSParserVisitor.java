// Generated from CSSParser.g4 by ANTLR 4.13.2
 package antlrCSS; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSSParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#atRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtRule(CSSParser.AtRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#rule_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_(CSSParser.Rule_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#selectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorList(CSSParser.SelectorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(CSSParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#simpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSelector(CSSParser.SimpleSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#selectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorPart(CSSParser.SelectorPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#property_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_(CSSParser.Property_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CSSParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CSSParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#block_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_(CSSParser.Block_Context ctx);
}