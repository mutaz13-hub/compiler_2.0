package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class Tag_content extends Tag {
    List<Ident> ident = new ArrayList<>();
    String id;


    public List<Ident> getIdent() {
        return ident;
    }


    public void addIdent(Ident i) {
        this.ident.add(i);
    }



    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(int level) {
        return "Tag_content{" +

                ", id='" + id + '\'' +
                "ident=" + ident +

                '}';
    }
}
