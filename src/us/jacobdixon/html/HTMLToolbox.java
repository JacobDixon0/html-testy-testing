package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Collection;

public class HTMLToolbox {

    public static String sanitizeText(String string){
        return string.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
    }

    public static String sanitizeValue(String value) {
        return value.split(" ")[0];
    }

    public static ArrayList<String> sanitizeValues(Collection<String> values) {
        ArrayList<String> sanitizedValues = new ArrayList<>();
        for (String value : values) {
            sanitizedValues.add(sanitizeValue(value));
        }
        return sanitizedValues;
    }
}
