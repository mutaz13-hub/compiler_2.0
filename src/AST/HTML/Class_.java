package AST.HTML;

public class Class_ extends SimpleSelector{
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(int level) {
        return id == null ? "" : id;
    }
}
