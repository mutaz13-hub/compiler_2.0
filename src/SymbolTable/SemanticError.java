package SymbolTable;

public class SemanticError {
    public enum ErrorType {
        UNDEFINED_VARIABLE,
        TYPE_ERROR,
        SCOPE_ERROR,
        TYPE_MISMATCHED,
        MISSING_FLASK_VARIABLE,
        DUPLICATE_ID,
        INVALID_NESTING,
        MISSING_REQUIRED_ATTRIBUTE,
        DEPRECATED_TAG,
        EMPTY_TITLE
    }

    private ErrorType type;
    private String message;
    private int line;

    public SemanticError(ErrorType type, String message, int line) {
        this.type = type;
        this.message = message;
        this.line = line;
    }

    public ErrorType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "[" + type + "] Line " + line + ": " + message;
    }
}
