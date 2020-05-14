package us.jacobdixon.html;

import java.util.ArrayList;

public class HTMLToolbox {

    public static String sanitizeText(String string){
        return string.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
    }

    public static String sanitizeValue(String value) {
        return value.split(" ")[0].replace(" ", "");
    }

    public static ArrayList<String> sanitizeValues(ArrayList<String> values) {
        ArrayList<String> sanitizedValues = new ArrayList<>();
        for (String value : values) {
            sanitizedValues.add(sanitizeValue(value));
        }
        return sanitizedValues;
    }
}
