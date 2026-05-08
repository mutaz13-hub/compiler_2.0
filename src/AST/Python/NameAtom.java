package AST.Python;

public class NameAtom extends Atom{
    Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString(int level) {
        return name != null ? name.toString(0) : "";
    }

}
