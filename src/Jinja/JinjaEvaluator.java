package Jinja;

import java.util.List;
import java.util.Map;

/** Resolves simple Jinja expressions (dotted variable paths) against a context map. */
public class JinjaEvaluator {

    @SuppressWarnings("unchecked")
    public static Object resolve(String expr, Map<String, Object> context) {
        if (expr == null) return null;
        expr = expr.trim();
        if (expr.isEmpty()) return null;

        String[] parts = expr.split("\\.");
        Object current = context.get(parts[0]);
        for (int i = 1; i < parts.length && current != null; i++) {
            if (current instanceof Map) {
                current = ((Map<String, Object>) current).get(parts[i]);
            } else {
                return null; // can't drill further into a non-map value
            }
        }
        return current;
    }

    public static boolean isTruthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean) return (Boolean) value;
        if (value instanceof String) return !((String) value).isEmpty();
        if (value instanceof List) return !((List<?>) value).isEmpty();
        if (value instanceof Number) return ((Number) value).doubleValue() != 0;
        return true;
    }
}
