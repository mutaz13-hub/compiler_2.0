package AST.Python;

import java.util.ArrayList;
import java.util.List;

public class Testlist_comp extends Atom{
    List<Test> test =new ArrayList<>();


    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test.size(); i++) {
            sb.append(test.get(i).toString(0));
            if (i < test.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

}
