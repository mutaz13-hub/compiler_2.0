package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class Program extends Root {
    List<Root> html = new ArrayList<>();

    public List<Root> getStmts() {
        return html;
    }

    public void addHtmlContent(Root stmt) {
        this.html.add(stmt);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent(level)).append("Program {\n");

        for (Root node : html) {
            sb.append(node.toString(level + 1)).append("\n");
        }

        sb.append(indent(level)).append("}");

        return sb.toString();
    }


}
