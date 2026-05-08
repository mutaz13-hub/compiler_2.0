package AST.HTML;

public class Expr_content extends Expr {
    String id;
    float number;
    String double_qoute;



    public void setDouble_qoute(String double_qoute) {
        this.double_qoute = double_qoute;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString(int level) {
        return "Expr_content{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", double_qoute='" + double_qoute + '\'' +
                '}';
    }

}
