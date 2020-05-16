package us.jacobdixon.utils;

import java.io.File;

public class StringToolbox {

    public static String repeat(String string, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(string);
        }
        return repeatedString.toString();
    }

    public static String normalizePath(String path, boolean isDirectory) {
        path = ("/" + path).replaceAll("\\\\", "/").replaceAll("/{2,}", "/").trim();

        if (isDirectory) {
            if (!path.endsWith("/")) path += "/";
        } else {
            if (path.endsWith("/")) path = path.substring(0, path.length() - 1);
        }

        return path;
    }

    public static String normalizePath(String path) {
        String normalizedPath = normalizePath(path, false);

        File f = new File(path);
        if (f.exists()) {
            if (f.isDirectory()) {
                normalizedPath = normalizePath(path, true);
            } else {
                normalizedPath = normalizePath(path, false);
            }
        }
        return normalizedPath;
    }

}
