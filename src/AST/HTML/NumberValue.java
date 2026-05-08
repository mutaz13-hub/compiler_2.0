package AST.HTML;

public class NumberValue extends ValuePart {

     String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }


    @Override
    public String toString(int level) {
            return number.toString();
    }

}
