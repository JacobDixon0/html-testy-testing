package us.jacobdixon.dev;

import us.jacobdixon.html.HTMLDocument;
import us.jacobdixon.html.HTMLTaggedElement;

public class Main {

    public static void main(String[] args){
        HTMLDocument doc = HTMLDocument.getDefault();
        doc.setTitle("page title wow");
        doc.addStylesheet("https://www.jacobdixon.us/res/css/style.css");
        doc.addScript("https://www.jacobdixon.us/res/js/script.js");
        doc.setStyle("body{background-color: black;}");

        System.out.println(doc);
    }

}
