package Visitor;

import AST.CSS.*;
import SymbolTable.SemanticError;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CSSSemanticAnalyzer {
    private final List<SemanticError> errors = new ArrayList<>();

    public List<SemanticError> getErrors() { return errors; }

    public void analyze(CSSProgram program) {
        for (CSSRule rule : program.getRules()) {
            if (rule.getDeclarations().isEmpty()) {
                errors.add(new SemanticError(SemanticError.ErrorType.EMPTY_RULE,
                        "Empty CSS rule for selector(s): " + String.join(", ", rule.getSelectors()),
                        rule.getLine()));
            }
            Set<String> seen = new HashSet<>();
            for (CSSDeclaration d : rule.getDeclarations()) {
                if (!seen.add(d.getProperty())) {
                    errors.add(new SemanticError(SemanticError.ErrorType.DUPLICATE_PROPERTY,
                            "Duplicate property '" + d.getProperty() + "' in rule " + String.join(", ", rule.getSelectors()),
                            d.getLine()));
                }
            }
        }
    }
}
