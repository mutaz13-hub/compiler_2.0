package SymbolTable;

public class SymbolInfo {
    private String type; // variable, function, parameter
    private String dataType; // int, float, string, bool, etc.
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

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", DataType: " + dataType + ", Value: " + value + ", Line: " + line;
    }
}