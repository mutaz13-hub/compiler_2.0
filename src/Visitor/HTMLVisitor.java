package Visitor;

import AST.HTML.*;
import SymbolTable.HTMLSymbolTable;
import antlrHTML.HTMLParser;
import antlrHTML.HTMLParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class HTMLVisitor extends HTMLParserBaseVisitor<Program> {
    private HTMLSymbolTable symbolTable = new HTMLSymbolTable();

    public HTMLSymbolTable getSymbolTable() {
        return symbolTable;
    }
    @Override
    public Program visitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {

        symbolTable.enter("HTML_DOCUMENT");

        List<HtmlElementNode> elements = new ArrayList<>();

        for (HTMLParser.HtmlElementsContext htmlElementsCtx : ctx.htmlElements()) {

            HtmlElementNode element =
                    (HtmlElementNode) visit(htmlElementsCtx.htmlElement());

            if (element != null) {
                elements.add(element);
            }
        }
        symbolTable.exit();
        HtmlDocumentNode node = new HtmlDocumentNode(elements);
        node.setLine(ctx.getStart().getLine());
        return node;
    }

    @Override

    public Program visitHtmlElement(HTMLParser.HtmlElementContext ctx) {


        if (ctx.script() != null) {
            Program script = visit(ctx.script());
            if (script != null) script.setLine(ctx.getStart().getLine());
            return script;
        }

        if (ctx.style() != null) {
            Program style = visit(ctx.style());
            if (style != null) style.setLine(ctx.getStart().getLine());
            return style;
        }

        if (ctx.SCRIPTLET() != null) {
            return null;
        }

        String tagName = ctx.TAG_NAME(0).getText();
        symbolTable.enter(tagName);

        List<HtmlAttributeNode> attributes = new ArrayList<>();

        for (HTMLParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {

            HtmlAttributeNode attribute =
                    (HtmlAttributeNode) visit(attrCtx);

            if (attribute != null) {
                attributes.add(attribute);
            }
        }

        List<Program> children = new ArrayList<>();

        if (ctx.htmlContent() != null) {

            HTMLParser.HtmlContentContext content = ctx.htmlContent();

            
            if (content.children != null) {
                for (org.antlr.v4.runtime.tree.ParseTree childNode : content.children) {
                    Program child = null;
                    if (childNode instanceof HTMLParser.HtmlChardataContext) {
                        child = visit((HTMLParser.HtmlChardataContext) childNode);
                    } else if (childNode instanceof HTMLParser.HtmlElementContext) {
                        child = visit((HTMLParser.HtmlElementContext) childNode);
                    } else if (childNode instanceof HTMLParser.HtmlCommentContext) {
                        child = visit((HTMLParser.HtmlCommentContext) childNode);
                    }
                    if (child != null) {
                        children.add(child);
                    }
                }
            }
        }
        symbolTable.exit();
        TagElementNode node = new TagElementNode(
                tagName,
                attributes,
                children
        );
        node.setLine(ctx.getStart().getLine());
        return node;
    }@Override
    public Program visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {

        String name =
                ctx.TAG_NAME().getText();

        String value = null;

        if (ctx.ATTVALUE_VALUE() != null) {
            value = ctx.ATTVALUE_VALUE().getText();
            symbolTable.define(
                    name,
                    "ATTRIBUTE",
                    "string",
                    value,
                    ctx.getStart().getLine());
        }

        HtmlAttributeNode node = new HtmlAttributeNode(name, value);
        node.setLine(ctx.getStart().getLine());
        return node;
    }

    @Override
    public Program visitHtmlChardata(
            HTMLParser.HtmlChardataContext ctx) {

        String text =
                ctx.getText().trim();

        if (text.isEmpty()) {
            return null;
        }

        TextNode node = new TextNode(text);
        node.setLine(ctx.getStart().getLine());
        return node;
    }

    @Override
    public Program visitHtmlComment(
            HTMLParser.HtmlCommentContext ctx) {

        CommentNode node = new CommentNode(
                ctx.getText()
        );
        node.setLine(ctx.getStart().getLine());
        return node;
    }

    @Override
    public Program visitScript(HTMLParser.ScriptContext ctx) {

        ScriptNode node = new ScriptNode(ctx.getText()
        );
        node.setLine(ctx.getStart().getLine());
        return node;
    }

    @Override
    public Program visitStyle(
            HTMLParser.StyleContext ctx) {

        StyleNode node = new StyleNode(
                ctx.getText()
        );
        node.setLine(ctx.getStart().getLine());
        return node;
    }
}