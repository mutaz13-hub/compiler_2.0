package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Trailer extends AtomExpr{
    Name name;
    ArrayList<Test> test ;

    public Trailer() {
        this.test = new ArrayList<>();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setTest(Test test) {
        this.test.add(test);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        if (name != null) sb.append(".").append(name.toString(0));
        for (Test t : test) {
            sb.append("(").append(t.toString(0)).append(")");
        }
        return sb.toString();
    }

}
