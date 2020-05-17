package us.jacobdixon.dev;

import us.jacobdixon.html.HTMLAbstractElement;
import us.jacobdixon.html.HTMLAttribute;
import us.jacobdixon.html.HTMLDocument;
import us.jacobdixon.html.HTMLElement;
import us.jacobdixon.html.elements.Img;
import us.jacobdixon.html.elements.ListItem;
import us.jacobdixon.html.elements.UnorderedList;
import us.jacobdixon.html.elements.extended.Anchor;
import us.jacobdixon.html.elements.extended.Div;
import us.jacobdixon.html.elements.extended.Paragraph;
import us.jacobdixon.html.elements.extended.TextHeader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static us.jacobdixon.utils.StringUtils.normalizePath;

public class Testing {

    private static ArrayList<String> includedPaths = new ArrayList<>();
    private static ArrayList<String> recursivelyIncludedPaths = new ArrayList<>();
    private static ArrayList<String> ignoredPaths = new ArrayList<>();
    private static ArrayList<String> recursivelyIgnoredPaths = new ArrayList<>();

    public static void main(String[] args) {
        HTMLDocument doc = HTMLDocument.getDefault();
        doc.setTitle("title");
        doc.addStylesheet("https://www.jacobdixon.us/res/css/primary.css");
        doc.setIcon("https://google.com/favicon.ico");
        doc.addScript("https://www.jacobdixon.us/res/js/primary.js");

        Div section = new Div();
        section.setId("section-1");

        TextHeader h1 = new TextHeader(1, "Header Wow");
        Paragraph p1 = new Paragraph("This is a paragraph wow epic.");
        Paragraph p2 = new Paragraph("this is another paragraph woah");

        p2.setData("what", "wow");
        System.out.println("data thingy thing: " + p2.getData("what"));
        p2.addChildElement(new Anchor("https://www.jacobdixon.us", Anchor.Target.Blank).setText("this b a link"));

        p2.addChildElements(" and this is some more text wooowwww");

        TextHeader h2 = new TextHeader(2, "Another Header Wow");
        UnorderedList ul1 = new UnorderedList();

        for(int i = 0; i < 10; i++){
            ListItem li = new ListItem();
            li.setChildElement("list item " + i);
            ul1.addChildElement(li);
        }

        Img image = new Img();
        image.setAttribute("src", "https://www.jacobdixon.us/res/img/header-bg-1.jpg");
        image.setAttribute("width", "200");

        section.addChildElements(h1, p1, p2, h2, ul1, image);

        Div section1 = new Div();

        section1.setClasses("class1", "class2");
        section1.setId("another-section");

        section1.addChildElement(new Anchor("https://google.com", Anchor.Target.Blank).setText("this is a link"));

        doc.getBody().addChildElement(section);
        doc.getBody().addChildElement(section1);

        try {
            printToFile("C:\\Users\\Quack\\Desktop\\test_page.html", doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.html());
    }

    static void resetConfigs() {
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
                String filePath = normalizePath(matchInclude.group(2), true);
                if (matchInclude.group(1) != null && matchInclude.group(1).contains("r")) {
                    recursivelyIncludedPaths.add(filePath);
                } else {
                    includedPaths.add(filePath);
                }
            } else if (matchIgnore.find()) {
                String filePath = normalizePath(matchIgnore.group(2), true);
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
