package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Collection;

public abstract class HTML {
    public static String sanitizeText(String string) {
        return string
                .replaceAll("\n", "<br>")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&apos;")
                .replaceAll("&", "&amp;");
    }

    public static String sanitizeValue(String value) {
        return value.split(" ")[0];
    }

    public static ArrayList<String> sanitizeValues(Collection<String> values) {
        ArrayList<String> sanitizedValues = new ArrayList<>();
        for (String value : values) sanitizedValues.add(sanitizeValue(value));
        return sanitizedValues;
    }
}
