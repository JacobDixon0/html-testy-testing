package us.jacobdixon.dev;

import us.jacobdixon.html.HTMLDocument;
import us.jacobdixon.html.elements.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static us.jacobdixon.html.HTML.tag;
import static us.jacobdixon.utils.StringToolbox.normalizePath;

public class Testing {

    private static ArrayList<String> includedPaths = new ArrayList<>();
    private static ArrayList<String> recursivelyIncludedPaths = new ArrayList<>();
    private static ArrayList<String> ignoredPaths = new ArrayList<>();
    private static ArrayList<String> recursivelyIgnoredPaths = new ArrayList<>();

    public static void main(String[] args) {
    }

    static void resetConfigs(){
        includedPaths.clear();
        recursivelyIncludedPaths.clear();
        ignoredPaths.clear();
        recursivelyIgnoredPaths.clear();
    }

    static void readConfig(String path) throws FileNotFoundException {
        resetConfigs();

        Scanner sc = new Scanner(new File(path));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            Matcher matchInclude = getVariableMatcher("include", line);
            Matcher matchIgnore = getVariableMatcher("ignore", line);

            if (matchInclude.find()) {
                String filePath = normalizePath(matchInclude.group(2));
                if (matchInclude.group(1) != null && matchInclude.group(1).contains("r")) {
                    recursivelyIncludedPaths.add(filePath);
                } else {
                    includedPaths.add(filePath);
                }
            } else if (matchIgnore.find()) {
                String filePath = normalizePath(matchIgnore.group(2));
                if (matchIgnore.group(1) != null && matchIgnore.group(1).contains("r")) {
                    recursivelyIgnoredPaths.add(filePath);
                } else {
                    ignoredPaths.add(filePath);
                }
            }
        }
    }

    static Matcher getVariableMatcher(String configName, String line) {
        configName = configName.replaceAll("\\s", "");
        return Pattern.compile("^" + configName + "\\s+(?:-([A-z0-9]+)\\s+)?\"(.+)\"$").matcher(line);
    }

    static Matcher getStrictMatcher(String configName, String line) {
        configName = configName.replaceAll("\\s", "");
        return Pattern.compile("^" + configName + "=\"(.+)\"$").matcher(line);
    }

    static void printToFile(String path, String content) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(content);

        pw.close();
        fw.close();
    }

}
