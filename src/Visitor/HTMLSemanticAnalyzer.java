package Visitor;

import AST.HTML.*;
import SymbolTable.SemanticError;
import java.util.*;

public class HTMLSemanticAnalyzer {
    private List<SemanticError> errors = new ArrayList<>();
    private Set<String> usedIds = new HashSet<>();
    private static final Set<String> DEPRECATED_TAGS = new HashSet<>(Arrays.asList(
        "font", "center", "strike", "basefont", "big", "dir", "applet", "acronym", "tt"
    ));

    public List<SemanticError> getErrors() {
        return errors;
    }

    public void analyze(HtmlDocumentNode document) {
        for (HtmlElementNode element : document.getElements()) {
            analyzeNode(element);
        }
    }

    private void analyzeNode(Program node) {
        if (node == null) return;

        if (node instanceof TagElementNode) {
            TagElementNode tag = (TagElementNode) node;
            String tagName = tag.getTagName().toLowerCase();

           
            if (DEPRECATED_TAGS.contains(tagName)) {
                errors.add(new SemanticError(SemanticError.ErrorType.DEPRECATED_TAG,
                    "Deprecated tag used: <" + tagName + ">", tag.getLine()));
            }

           
            checkAttributes(tag);

           
            checkNesting(tag);

            
            if (tagName.equals("title")) {
                checkEmptyTitle(tag);
            }

            
            for (Program child : tag.getChildren()) {
                analyzeNode(child);
            }
        }
    }

    private void checkAttributes(TagElementNode tag) {
        String tagName = tag.getTagName().toLowerCase();
        boolean hasSrc = false;
        boolean hasAlt = false;
        boolean hasHref = false;

        for (HtmlAttributeNode attr : tag.getAttributes()) {
            String name = attr.getName().toLowerCase();
            String value = attr.getValue();

            
            if (name.equals("id") && value != null) {
                // Remove quotes from value if present
                String idValue = value.replace("\"", "").replace("'", "");
                if (usedIds.contains(idValue)) {
                    errors.add(new SemanticError(SemanticError.ErrorType.DUPLICATE_ID,
                        "Duplicate ID found: '" + idValue + "'", attr.getLine()));
                }
                usedIds.add(idValue);
            }

            if (name.equals("src")) hasSrc = true;
            if (name.equals("alt")) hasAlt = true;
            if (name.equals("href")) hasHref = true;
        }

        
        if (tagName.equals("img")) {
            if (!hasSrc) {
                errors.add(new SemanticError(SemanticError.ErrorType.MISSING_REQUIRED_ATTRIBUTE,
                    "Tag <img> is missing required attribute 'src'", tag.getLine()));
            }
            if (!hasAlt) {
                errors.add(new SemanticError(SemanticError.ErrorType.MISSING_REQUIRED_ATTRIBUTE,
                    "Tag <img> is missing required attribute 'alt' for accessibility", tag.getLine()));
            }
        } else if (tagName.equals("a")) {
            if (!hasHref) {
                errors.add(new SemanticError(SemanticError.ErrorType.MISSING_REQUIRED_ATTRIBUTE,
                    "Tag <a> is missing required attribute 'href'", tag.getLine()));
            }
        }
    }

    private void checkNesting(TagElementNode tag) {
        String tagName = tag.getTagName().toLowerCase();
        for (Program child : tag.getChildren()) {
            if (child instanceof TagElementNode) {
                TagElementNode childTag = (TagElementNode) child;
                String childName = childTag.getTagName().toLowerCase();

        
                if (tagName.equals("a") && childName.equals("a")) {
                    errors.add(new SemanticError(SemanticError.ErrorType.INVALID_NESTING,
                        "Invalid nesting: <a> tag cannot contain another <a> tag", childTag.getLine()));
                }

        
                if ((tagName.equals("ul") || tagName.equals("ol")) && !childName.equals("li")) {
                     errors.add(new SemanticError(SemanticError.ErrorType.INVALID_NESTING,
                        "Invalid nesting: <" + tagName + "> can only contain <li> tags, but found <" + childName + ">", childTag.getLine()));
                }
            }
        }
    }

    private void checkEmptyTitle(TagElementNode tag) {
        boolean hasContent = false;
        for (Program child : tag.getChildren()) {
            if (child instanceof TextNode) {
                if (!((TextNode) child).getText().trim().isEmpty()) {
                    hasContent = true;
                    break;
                }
            }
        }
        if (!hasContent) {
            errors.add(new SemanticError(SemanticError.ErrorType.EMPTY_TITLE,
                "Tag <title> should not be empty", tag.getLine()));
        }
    }
}
