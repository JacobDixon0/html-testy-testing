package us.jacobdixon.utils;

public class StringToolbox {

    public static String repeat(String string, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(string);
        }
        return repeatedString.toString();
    }

}
