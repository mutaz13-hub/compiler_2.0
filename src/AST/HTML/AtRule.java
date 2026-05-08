package AST.HTML;

import java.util.ArrayList;
import java.util.List;

public class AtRule extends Style {
    List<ValuePart> valuePart = new ArrayList<>();
    List<String> id = new ArrayList<>();
    List<Float> number = new ArrayList<>();
    AtRuleBody atRuleBody;

    public List<ValuePart> getValuePart() {
        return valuePart;
    }

    public void setValuePart(ValuePart valuePart) {
        this.valuePart.add(valuePart);
    }

    public List<String> getId() {
        return id;
    }

    public void setId(String id) {
        this.id.add(id);
    }

    public List<Float> getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number.add(number);
    }

    public AtRuleBody getAtRuleBody() {
        return atRuleBody;
    }

    public void setAtRuleBody(AtRuleBody atRuleBody) {
        this.atRuleBody = atRuleBody;
    }

    @Override
    public String toString(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        if (valuePart != null){
            stringBuilder.append(valuePart);
        }
        else if (number != null || id != null){
        stringBuilder.append("url");
        stringBuilder.append(number);
        stringBuilder.append(id);
        }
        stringBuilder.append(atRuleBody);
        return stringBuilder.toString();
    }
}
