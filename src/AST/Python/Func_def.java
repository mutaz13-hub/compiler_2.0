package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Func_def extends Compound_stmt{
     Name name;
     List<Name> params = new ArrayList<>();
     Test returnType;
     Suite suite;
    int line;
    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Name> getParams() {
        return params;
    }

    public void addParam(Name param) {
        this.params.add(param);
    }

    public Test getReturnType() {
        return returnType;
    }

    public void setReturnType(Test returnType) {
        this.returnType = returnType;
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
        sb.append(indent(level+1)).append("def ").append(name != null ? name.toString(0) : "");
        sb.append("(");
        for (int i = 0; i < params.size(); i++) {
            sb.append(params.get(i).toString(0));
            if (i < params.size() - 1) sb.append(", ");
        }
        sb.append(")");
        if (returnType != null) sb.append(" -> ").append(returnType.toString(0));
        if (suite != null) sb.append(":\n").append(suite.toString(level + 2));
        return sb.toString();
    }

}
