package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class Rule extends Style {
    Selector selector;
    List<String> ID = new ArrayList<>();
    List<Declaration> declaration = new ArrayList<>();

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public List<String> getID() {
        return ID;
    }


    public void addID(String id) {
        this.ID.add(id);
    }

    public List<Declaration> getDeclaration() {
        return declaration;
    }


    public void addDeclaration(Declaration decl) {
        this.declaration.add(decl);
    }

    @Override
    public String toString(int level) {
        return "Rule{" +
                "selector=" + selector +
                ", ID=" + ID +
                ", declaration=" + declaration +
                '}';
    }
}
