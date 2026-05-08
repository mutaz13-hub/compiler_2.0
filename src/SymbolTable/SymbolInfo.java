package SymbolTable;

public class SymbolInfo {
    private String type;
    private String value;
    private int line;

    public SymbolInfo(String type, String value, int line) {
        this.type = type;
        this.value = value;
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Value: " + value + ", Line: " + line;
    }
}