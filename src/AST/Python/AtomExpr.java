package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class AtomExpr extends Expr {
    Atom atom;
    List<Trailer> trailers = new ArrayList<>();

    public void setAtom(Atom atom) {
        this.atom = atom;
    }

    public void addTrailer(Trailer trailer) {
        this.trailers.add(trailer);
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(level )).append("AtomExpr: ");
        if (atom != null) sb.append(atom.toString(0));
        if (!trailers.isEmpty()) {
            for (Trailer t : trailers) {
                sb.append(t.toString(0));
            }
        }
        return sb.toString();
    }

}
