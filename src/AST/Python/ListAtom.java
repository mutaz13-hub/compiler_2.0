package AST.Python;

public class ListAtom extends Atom{
    Testlist_comp testlist_comp;


    public Testlist_comp getTestlist_comp() {
        return testlist_comp;
    }

    public void setTestlist_comp(Testlist_comp testlist_comp) {
        this.testlist_comp = testlist_comp;
    }


    @Override
    public String toString(int level) {
        return testlist_comp != null ? testlist_comp.toString(0) : "[]";
    }

}
