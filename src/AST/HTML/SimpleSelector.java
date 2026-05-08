package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class SimpleSelector extends Selector {

     TypeSelector id;
     List<Class_> classes = new ArrayList<>();
     List<Attrib> attribs = new ArrayList<>();


    public void setTypeSelector(TypeSelector id) {
        this.id = id;
    }

    public void addClass(Class_ cls) {
        classes.add(cls);
    }

    public void addAttrib(Attrib attrib) {
        attribs.add(attrib);
    }



    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        if (id != null) sb.append(id);
        classes.forEach(sb::append);
        attribs.forEach(sb::append);
        return sb.toString();
    }
}
