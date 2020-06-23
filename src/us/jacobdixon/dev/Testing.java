package us.jacobdixon.dev;

import us.jacobdixon.html.HTMLAbstractElement;
import us.jacobdixon.html.HTMLDocument;
import us.jacobdixon.html.HTMLElement;
import us.jacobdixon.html.elements.Img;
import us.jacobdixon.html.elements.extended.*;
import us.jacobdixon.html.elements.extended.text.Paragraph;
import us.jacobdixon.html.elements.extended.text.TextHeader;

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

        for (int i = 0; i < 10; i++) {
            ul1.addChildElement(new ListItem("list item " + i));
        }

        ArrayList<ListItem> items = new ArrayList<>();

        ListItem item1 = new ListItem();
        item1.setChildElement("item 1");
        ListItem item2 = new ListItem();
        item2.setChildElement("item 2");

        items.add(item1);
        items.add(item2);

        UnorderedList ul2 = new UnorderedList(items);

        System.out.println("wowww " + ul2.getItem(1));

        Img image = new Img();
        image.setAttribute("src", "https://www.jacobdixon.us/res/img/header-bg-1.jpg");
        image.setAttribute("width", "200");

        section.addChildElements(h1, p1, p2, h2, ul1, ul2, image);

        Div section1 = new Div();

        section1.setClasses("class1", "class2");
        section1.setId("another-section");

        section1.addChildElement(new Anchor("https://google.com", Anchor.Target.Blank).setText("this is a link"));

        doc.getHeader().addComment("this is a comment wow");

        doc.getBody().addChildElement(section);
        doc.getBody().addChildElement(section1);

        for (HTMLAbstractElement element : section.getChildElements(true)) {
            if (element instanceof HTMLElement) {
                System.out.println(((HTMLElement) element).getTag());
            } else {
                System.out.println("\"" + element.html() + "\"");
            }
        }

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
