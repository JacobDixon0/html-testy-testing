package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Arrays;

import static us.jacobdixon.html.HTMLToolbox.sanitizeValue;
import static us.jacobdixon.html.HTMLToolbox.sanitizeValues;

public class HTMLAttribute {

    private String key;
    private ArrayList<String> values = new ArrayList<>();

    public HTMLAttribute(String key) {
        this.key = key;
    }

    public HTMLAttribute(String key, String... values) {
        this.key = key;
        this.values = sanitizeValues(new ArrayList<>(Arrays.asList(values)));
    }

    public void addValue(String value) {
        value = sanitizeValue(value);
        if (!values.contains(value)) this.values.add(value);
    }

    public void removeValue(String value) {
        value = sanitizeValue(value);
        if (values.contains(value)) {
            this.values.remove(value);
        }
    }

    public String getValuesString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            if (i != 0) sb.append(" ");
            sb.append(values.get(i));
        }
        return sb.toString();
    }

    public void setValuesString(String values) {
        this.values.clear();
        for (String value : values.split(" ")) {
            this.values.add(sanitizeValue(value));
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(String... values) {
        this.values = sanitizeValues(new ArrayList<>(Arrays.asList(values)));
    }

    @Override
    public String toString() {
        String s = key;
        if (!values.isEmpty()) s += "=\"" + getValuesString() + "\"";
        return s;
    }
}