package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class If_stmt extends Compound_stmt{
     String keyword;
     Test condition;
     Suite suite;
    int line;
    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Test getCondition() {
        return condition;
    }

    public void setCondition(Test condition) {
        this.condition = condition;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level)).append("line").append(line).append("\n");
        sb.append(indent(level+1)).append(keyword != null ? keyword : "if").append(" ");
        if (condition != null) sb.append(condition.toString(0));
        if (suite != null) sb.append(":\n").append(suite.toString(level + 1));
        return sb.toString();
    }

}
