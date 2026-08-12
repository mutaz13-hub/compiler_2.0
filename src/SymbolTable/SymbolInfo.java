package SymbolTable;

public class SymbolInfo {
    private String type;
    private String dataType;
    private String value;
    private int line;

    public SymbolInfo(String type, String dataType, String value, int line) {
        this.type = type;
        this.dataType = dataType;
        this.value = value;
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public String getDataType() {
        return dataType;
    }

    public String getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "SymbolInfo{type=" + type + ", dataType=" + dataType + ", value=" + value + ", line=" + line + "}";
    }
}
