package AST.HTML;


import java.util.ArrayList;
import java.util.List;

public class Expr extends Statement {

    private List<Expr_content> expr_content = new ArrayList<>();

    public void addExpr_content(Expr_content content) {
        this.expr_content.add(content);
    }

    public List<Expr_content> getExpr_content() {
        return expr_content;
    }

    @Override
    public String toString(int level) {
        return "Expr{" +
                "expr_content=" + expr_content +
                '}';
    }
}
