package Visitor;

import AST.CSS.*;
import antlrCSS.CSSParser;
import antlrCSS.CSSParserBaseVisitor;

public class CSSVisitor extends CSSParserBaseVisitor<Object> {

    public CSSProgram visitProgram(CSSParser.StylesheetContext ctx) {
        CSSProgram program = new CSSProgram();
        program.setLine(1);
        for (CSSParser.Rule_Context rctx : ctx.rule_()) {
            program.addRule(buildRule(rctx));
        }
        return program;
    }

    private CSSRule buildRule(CSSParser.Rule_Context ctx) {
        CSSRule rule = new CSSRule();
        rule.setLine(ctx.getStart().getLine());
        for (CSSParser.SelectorContext sctx : ctx.selectorList().selector()) {
            rule.addSelector(sctx.getText());
        }
        for (CSSParser.DeclarationContext dctx : ctx.declaration()) {
            CSSDeclaration decl = new CSSDeclaration();
            decl.setLine(dctx.getStart().getLine());
            decl.setProperty(dctx.property_().getText());
            StringBuilder val = new StringBuilder();
            for (CSSParser.ValueContext vctx : dctx.value()) {
                if (val.length() > 0) val.append(" ");
                val.append(vctx.getText());
            }
            decl.setValue(val.toString());
            rule.addDeclaration(decl);
        }
        return rule;
    }
}
