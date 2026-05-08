package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class Tag extends Html_content {
    Tag_content tag_content;
    List<String> id = new ArrayList<>();

    public Tag_content getTag_content() {
        return tag_content;
    }

    public void setTag_content(Tag_content tag_content) {
        this.tag_content = tag_content;
    }

    public List<String> getId() {
        return id;
    }

    public void addId(String id) {
        this.id.add(id);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent(level)).append("Tag {\n");

        sb.append(indent(level + 1))
                .append("tag_content:\n")
                .append(tag_content.toString(level + 2))
                .append("\n");

        if (!id.isEmpty()) {
            sb.append(indent(level + 1))
                    .append("id: ")
                    .append(id)
                    .append("\n");
        }

        sb.append(indent(level)).append("}");

        return sb.toString();
    }
}
