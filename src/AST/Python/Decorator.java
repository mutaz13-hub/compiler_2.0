package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Decorator extends Decorated {
     List<Name> names = new ArrayList<>();
     List<Test> args = new ArrayList<>();

    public List<Name> getNames() {
        return names;
    }

    public void addName(Name name) {
        this.names.add(name);
    }

    public List<Test> getArgs() {
        return args;
    }

    public void addArg(Test t) {
        this.args.add(t);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i).toString(0));
            if (i < names.size() - 1) sb.append(".");
        }
        if (!args.isEmpty()) {
            sb.append("(");
            for (int i = 0; i < args.size(); i++) {
                sb.append(args.get(i).toString(0));
                if (i < args.size() - 1) sb.append(", ");
            }
            sb.append(")");
        }
        return sb.toString();
    }

}
