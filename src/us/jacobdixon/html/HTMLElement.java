package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Arrays;

import static us.jacobdixon.html.HTMLToolbox.sanitizeValue;

public class HTMLElement implements HTMLContent {

    private String tag;
    private ArrayList<HTMLAttribute> attributes = new ArrayList<>();
    private ArrayList<HTMLContent> contents = new ArrayList<>();
    private boolean isSelfClosing;

    public HTMLElement(String tag) {
        this.tag = tag;
        this.isSelfClosing = checkIfSelfClosing(tag);
    }

    private static boolean checkIfSelfClosing(String tag) {
        tag = tag.toLowerCase();
        boolean isSelfClosing = false;

        if (tag.equals("area")       ||
                tag.equals("img")    ||
                tag.equals("base")   ||
                tag.equals("br")     ||
                tag.equals("col")    ||
                tag.equals("embed")  ||
                tag.equals("hr")     ||
                tag.equals("iframe") ||
                tag.equals("input")  ||
                tag.equals("link")   ||
                tag.equals("meta")   ||
                tag.equals("param")  ||
                tag.equals("source") ||
                tag.equals("track")  ||
                tag.equals("wbr")) {
            isSelfClosing = true;
        } else if (tag.matches("^![A-z0-9]+.+$")){
            isSelfClosing = true;
        }
        return isSelfClosing;
    }

    public HTMLElement setAttribute(String key, String... values) {
        boolean prexisting = false;
        for (HTMLAttribute attrib : attributes) {
            if (attrib.getKey().equals(key)) {
                prexisting = true;
                attrib.setValues(values);
                break;
            }
        }
        if (!prexisting) {
            attributes.add(new HTMLAttribute(key, values));
        }
        return this;
    }

    public HTMLElement setAttribute(String key) {
        boolean prexisting = false;
        for (HTMLAttribute attrib : attributes) {
            if (attrib.getKey().equals(key)) {
                prexisting = true;
                break;
            }
        }
        if (!prexisting) {
            attributes.add(new HTMLAttribute(key));
        }
        return this;
    }

    public HTMLElement clearAttribute(String key) {
        HTMLAttribute attribute = new HTMLAttribute(key);
        boolean prexisting = false;
        for (HTMLAttribute attrib : attributes) {
            if (attrib.getKey().equals(key)) {
                prexisting = true;
                attribute = attrib;
                break;
            }
        }
        if (prexisting) {
            attributes.remove(attribute);
        }
        return this;
    }

    public HTMLAttribute getAttribute(String key) {
        HTMLAttribute attribute = null;
        for (HTMLAttribute attrib : attributes) {
            if (attrib.getKey().equals(key)) {
                attribute = attrib;
            }
        }
        return attribute;
    }

    public HTMLElement addContents(String... contents) {
        for (String s : contents) {
            this.contents.add(new HTMLTextContent(s));
        }
        return this;
    }

    public HTMLElement addContents(HTMLContent... contents) {
        this.contents.addAll(Arrays.asList(contents));
        return this;
    }

    public HTMLElement removeContents(HTMLContent content) {
        contents.remove(content);
        return this;
    }

    public HTMLElement clearAttributes() {
        attributes.clear();
        return this;
    }

    public HTMLElement clearContents() {
        contents.clear();
        return this;
    }

    public HTMLElement setId(String id) {
        setAttribute("id", id);
        return this;
    }

    public HTMLElement clearId() {
        clearAttribute("id");
        return this;
    }

    public HTMLElement setClasses(String... classes) {
        setAttribute("class", classes);
        return this;
    }

    public HTMLElement addClass(String className) {
        className = sanitizeValue(className);
        if (getAttribute("class") == null) {
            setClasses(className);
        } else {
            getAttribute("class").addValue(className);
        }
        return this;
    }

    public HTMLElement removeClass(String className) {
        className = sanitizeValue(className);
        if (getAttribute("class") != null) {
            getAttribute("class").removeValue(className);
            if (getAttribute("class").getValues().isEmpty()) clearAttribute("class");
        }
        return this;
    }

    public HTMLElement clearClasses() {
        clearAttribute("class");
        return this;
    }

    public String getTag() {
        return tag;
    }

    public HTMLElement setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public ArrayList<HTMLAttribute> getAttributes() {
        return attributes;
    }

    public HTMLElement setAttributes(ArrayList<HTMLAttribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public ArrayList<HTMLContent> getContents() {
        return contents;
    }

    public HTMLElement setContents(ArrayList<HTMLContent> contents) {
        this.contents = contents;
        return this;
    }

    public boolean isSelfClosing() {
        return isSelfClosing;
    }

    public HTMLElement setSelfClosing(boolean selfClosing) {
        isSelfClosing = selfClosing;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(tag);

        for (HTMLAttribute attrib : attributes) {
            sb.append(" ").append(attrib.toString());
        }

        sb.append(">");

        if (!isSelfClosing) {
            for (HTMLContent content : contents) {
                sb.append(content.toString());
            }
            sb.append("</").append(tag).append(">");
        }

        return sb.toString();
    }
}
