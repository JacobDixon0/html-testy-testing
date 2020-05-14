package us.jacobdixon.utils;

public class Variables {

    public static String notNull(String string) {
        if (string == null) string = "";
        return string;
    }
}
