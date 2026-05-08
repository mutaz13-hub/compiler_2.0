package AST.HTML;

public class Ident extends Tag_content {
    String id;
    String doubleQuote;



    public void setId(String id) {
        this.id = id;
    }

    public String getDoubleQuote() {
        return doubleQuote;
    }

    public void setDoubleQuote(String doubleQuote) {
        this.doubleQuote = doubleQuote;
    }

    @Override
    public String toString(int level) {
        StringBuilder sb = new StringBuilder();
        if (id != null) sb.append("id=").append(id);
        if (doubleQuote != null) sb.append("doubleQuote=").append(doubleQuote);
        return sb.toString();
    }
}
