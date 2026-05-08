package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class UrlValue extends ValuePart {

    private List<String> id = new ArrayList<>();
    private List<Float> number = new ArrayList<>();

    public List<String> getId() { return id; }
    public void addId(String id) { this.id.add(id); }

    public List<Float> getNumber() { return number; }
    public void addNumber(Float number) { this.number.add(number); }


    @Override
    public String toString(int level) {
        return "UrlValue{" +
                ", id=" + id +
                ", number=" + number +
                '}';
    }
}
