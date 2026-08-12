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
        EMPTY_TITLE,
        EMPTY_RULE,
        DUPLICATE_PROPERTY,
        UNDEFINED_TEMPLATE_VARIABLE,
        UNCLOSED_BLOCK,
        FOR_NOT_ITERABLE,
        INVALID_ATTRIBUTE_ACCESS,
        EMPTY_LOOP_BODY,
        DUPLICATE_LOOP_VARIABLE
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
