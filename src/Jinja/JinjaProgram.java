package Jinja;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Root node of a parsed Jinja template - an ordered list of child nodes. */
public class JinjaProgram extends JinjaNode {
    private final List<JinjaNode> children = new ArrayList<>();

    public List<JinjaNode> getChildren() { return children; }
    public void addChild(JinjaNode node) { children.add(node); }

    @Override
    public void render(Map<String, Object> context, StringBuilder out) {
        for (JinjaNode child : children) {
            child.render(context, out);
        }
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "JINJA_PROGRAM");
        for (JinjaNode child : children) {
            child.print(indent + 1);
        }
    }
}
