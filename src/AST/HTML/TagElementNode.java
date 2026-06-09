package AST.HTML;

import java.util.List;

public class TagElementNode extends HtmlElementNode {

    private String tagName;
    private List<HtmlAttributeNode> attributes;
    private List<Program> children;

    public TagElementNode(
            String tagName,
            List<HtmlAttributeNode> attributes,
            List<Program> children) {

        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
    }

    public String getTagName() {
        return tagName;
    }

    public List<HtmlAttributeNode> getAttributes() {
        return attributes;
    }

    public List<Program> getChildren() {
        return children;
    }

    @Override
    public String toString(int level) {

        StringBuilder sb = new StringBuilder();

        sb.append(indent(level))
                .append("TAG : ")
                .append(tagName)
                .append("\n");

        if (!attributes.isEmpty()) {

            sb.append(indent(level + 1))
                    .append("ATTRIBUTES\n");

            for (HtmlAttributeNode attribute : attributes) {
                sb.append(attribute.toString(level + 2));
            }
        }

        if (!children.isEmpty()) {

            sb.append(indent(level + 1))
                    .append("CHILDREN\n");

            for (Program child : children) {
                sb.append(child.toString(level + 2));
            }
        }

        return sb.toString();
    }
}