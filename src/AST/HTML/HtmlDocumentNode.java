package AST.HTML;

import java.util.List;

public class HtmlDocumentNode extends Program {

    private List<HtmlElementNode> elements;

    public HtmlDocumentNode(List<HtmlElementNode> elements) {
        this.elements = elements;
    }

    public List<HtmlElementNode> getElements() {
        return elements;
    }

    @Override
    public String toString(int level) {

        StringBuilder sb = new StringBuilder();

        sb.append(indent(level))
                .append("HTML_DOCUMENT\n");

        for (HtmlElementNode element : elements) {
            sb.append(element.toString(level + 1));
        }

        return sb.toString();
    }
}