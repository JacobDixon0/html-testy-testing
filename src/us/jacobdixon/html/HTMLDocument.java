package us.jacobdixon.html;

import java.util.ArrayList;

public class HTMLDocument {

    private String doctype;
    private ArrayList<HTMLContent> contents = new ArrayList<>();

    public HTMLDocument(String doctype) {
        contents.add(new HTMLElement("!DOCTYPE").setAttribute(doctype));
        this.doctype = doctype;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public ArrayList<HTMLContent> getContents() {
        return contents;
    }

    public void setContents(ArrayList<HTMLContent> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HTMLContent element : contents) { sb.append(element.toString()); }
        return sb.toString();
    }
}
