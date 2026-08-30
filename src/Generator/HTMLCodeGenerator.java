package Generator;

import AST.HTML.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;


public class HTMLCodeGenerator {
    private final StringWriter stringWriter = new StringWriter();
    private final PrintWriter emit = new PrintWriter(stringWriter);
    private int indentLevel = 0;

    public void generate(HtmlDocumentNode document) {
        if (document == null || document.getElements() == null) {
            throw new IllegalArgumentException("مستند الـ HTML فارغ! لا يمكن توليد الكود.");
        }

        emit.println("<!-- الكود المتولد تلقائياً بواسطة المترجم ;) -->");
        
        for (HtmlElementNode element : document.getElements()) {
            emitNode(element);
        }
    }

    private void emitNode(Program node) {
        if (node == null) return;

        if (node instanceof TagElementNode) {
            emitTag((TagElementNode) node);
        } else if (node instanceof TextNode) {
            emitText((TextNode) node);
        } else if (node instanceof CommentNode) {
            emitComment((CommentNode) node);
        } else if (node instanceof ScriptNode) {
            emitScript((ScriptNode) node);
        } else if (node instanceof StyleNode) {
            emitStyle((StyleNode) node);
        }
    }

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            emit.print("    ");
        }
    }

    private void emitTag(TagElementNode node) {
        printIndent();
        emit.print("<" + node.getTagName());
        
        List<HtmlAttributeNode> attrs = node.getAttributes();
        for (HtmlAttributeNode attr : attrs) {
            emit.print(" " + attr.getName());
            if (attr.getValue() != null) {
                emit.print("=" + attr.getValue());
            }
        }

        List<Program> children = node.getChildren();
        if (children.isEmpty() && isSelfClosing(node.getTagName())) {
            emit.println(" />");
        } else {
            emit.println(">");
            indentLevel++;
            for (Program child : children) {
                emitNode(child);
            }
            indentLevel--;
            printIndent();
            emit.println("</" + node.getTagName() + ">");
        }
    }

    private void emitText(TextNode node) {
        printIndent();
        emit.println(node.getText());
    }

    private void emitComment(CommentNode node) {
        printIndent();
        emit.println(node.toString(0).trim());
    }

    private void emitScript(ScriptNode node) {
        printIndent();
        emit.println("<script>");
        emit.println(node.toString(0).trim().replace("SCRIPT : ", ""));
        printIndent();
        emit.println("</script>");
    }

    private void emitStyle(StyleNode node) {
        printIndent();
        emit.println("<style>");
        emit.println(node.toString(0).trim().replace("STYLE : ", ""));
        printIndent();
        emit.println("</style>");
    }

    private boolean isSelfClosing(String tag) {
        String t = tag.toLowerCase();
        return t.equals("img") || t.equals("br") || t.equals("hr") || t.equals("input") || t.equals("meta") || t.equals("link");
    }

    public String getGeneratedCode() {
        return stringWriter.toString();
    }
}
