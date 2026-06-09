package Visitor;

import AST.HTML.*;
import SymbolTable.HTMLSymbolTable;
import SymbolTable.PythonSymbolTable;
import antlrHTML.HTMLParser;
import antlrHTML.HTMLParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class HTMLVisitor extends HTMLParserBaseVisitor<Program> {
    private PythonSymbolTable symbolTable = new PythonSymbolTable();

    public PythonSymbolTable getSymbolTable() {
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
        return new HtmlDocumentNode(elements);
    }

    @Override

    public Program visitHtmlElement(HTMLParser.HtmlElementContext ctx) {


        if (ctx.script() != null) {
            return visit(ctx.script());
        }

        if (ctx.style() != null) {
            return visit(ctx.style());
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

            for (HTMLParser.HtmlChardataContext textCtx
                    : content.htmlChardata()) {

                Program text = visit(textCtx);

                if (text != null) {
                    children.add(text);
                }
            }

            for (HTMLParser.HtmlElementContext childCtx
                    : content.htmlElement()) {

                Program child = visit(childCtx);

                if (child != null) {
                    children.add(child);
                }
            }

            for (HTMLParser.HtmlCommentContext commentCtx
                    : content.htmlComment()) {

                Program comment = visit(commentCtx);

                if (comment != null) {
                    children.add(comment);
                }
            }
        }
        symbolTable.exit();
        return new TagElementNode(
                tagName,
                attributes,
                children
        );
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
                    value,
                    ctx.getStart().getLine());
        }

        return new HtmlAttributeNode(name, value);
    }

    @Override
    public Program visitHtmlChardata(
            HTMLParser.HtmlChardataContext ctx) {

        String text =
                ctx.getText().trim();

        if (text.isEmpty()) {
            return null;
        }

        return new TextNode(text);
    }

    @Override
    public Program visitHtmlComment(
            HTMLParser.HtmlCommentContext ctx) {

        return new CommentNode(
                ctx.getText()
        );
    }

    @Override
    public Program visitScript(HTMLParser.ScriptContext ctx) {

        return new ScriptNode(ctx.getText()
        );
    }

    @Override
    public Program visitStyle(
            HTMLParser.StyleContext ctx) {

        return new StyleNode(
                ctx.getText()
        );
    }
}