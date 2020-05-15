package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Arrays;

import static us.jacobdixon.utils.HTMLToolbox.sanitizeValue;
import static us.jacobdixon.utils.StringToolbox.repeat;

public class HTMLTaggedElement implements HTMLElement {

    private String tag;
    private ArrayList<HTMLAttribute> attributes = new ArrayList<>();
    private ArrayList<HTMLElement> childElements = new ArrayList<>();
    private boolean isSelfClosing;

    public HTMLTaggedElement(String tag) {
        this.tag = tag;
        this.isSelfClosing = checkIfSelfClosing(tag);
    }

    public HTMLTaggedElement(String tag, String id) {
        this.tag = tag;
        setId(id);
        this.isSelfClosing = checkIfSelfClosing(tag);
    }

    private static boolean checkIfSelfClosing(String tag) {
        tag = tag.toLowerCase();
        boolean isSelfClosing = false;

        if (tag.equals("area") ||
                tag.equals("img") ||
                tag.equals("base") ||
                tag.equals("br") ||
                tag.equals("col") ||
                tag.equals("embed") ||
                tag.equals("hr") ||
                tag.equals("iframe") ||
                tag.equals("input") ||
                tag.equals("link") ||
                tag.equals("meta") ||
                tag.equals("param") ||
                tag.equals("source") ||
                tag.equals("track") ||
                tag.equals("wbr")) {
            isSelfClosing = true;
        } else if (tag.matches("^![A-z0-9]+.+$")) {
            isSelfClosing = true;
        }
        return isSelfClosing;
    }

    public HTMLTaggedElement setAttribute(String key, String... values) {
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

    public HTMLTaggedElement setAttribute(String key) {
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

    public HTMLTaggedElement clearAttribute(String key) {
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

    public HTMLTaggedElement clearAttributes() {
        attributes.clear();
        return this;
    }

    public HTMLTaggedElement addChildElements(String... elements) {
        for (String s : elements) {
            this.childElements.add(new HTMLTextElement(s));
        }
        return this;
    }

    public HTMLTaggedElement addChildElements(HTMLElement... elements) {
        this.childElements.addAll(Arrays.asList(elements));
        return this;
    }

    public HTMLTaggedElement removeChildElement(HTMLElement element) {
        childElements.remove(element);
        return this;
    }

    public HTMLTaggedElement clearChildElements() {
        childElements.clear();
        return this;
    }

    public void addComment(String comment) {
        childElements.add(new HTMLComment(comment));
    }

    public void clearComments() {
        for (HTMLComment comment : getComments()) {
            childElements.remove(comment);
        }
    }

    public HTMLTaggedElement setId(String id) {
        setAttribute("id", id);
        return this;
    }

    public HTMLTaggedElement clearId() {
        clearAttribute("id");
        return this;
    }

    public HTMLTaggedElement setClasses(String... classes) {
        setAttribute("class", classes);
        return this;
    }

    public HTMLTaggedElement addClass(String className) {
        className = sanitizeValue(className);
        if (getAttribute("class") == null) {
            setClasses(className);
        } else {
            getAttribute("class").addValue(className);
        }
        return this;
    }

    public HTMLTaggedElement removeClass(String className) {
        className = sanitizeValue(className);
        if (getAttribute("class") != null) {
            getAttribute("class").removeValue(className);
            if (getAttribute("class").getValues().isEmpty()) clearAttribute("class");
        }
        return this;
    }

    public HTMLTaggedElement clearClasses() {
        clearAttribute("class");
        return this;
    }

    public String getId() {
        return getAttribute("id").getValue();
    }

    public String getClasses() {
        return getAttribute("class").getValue();
    }

    public String getTag() {
        return tag;
    }

    public HTMLTaggedElement setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public ArrayList<HTMLAttribute> getAttributes() {
        return attributes;
    }

    public HTMLTaggedElement setAttributes(ArrayList<HTMLAttribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public ArrayList<HTMLElement> getChildElements() {
        return childElements;
    }

    public HTMLTaggedElement setChildElements(ArrayList<HTMLElement> childElements) {
        this.childElements = childElements;
        return this;
    }

    public boolean isSelfClosing() {
        return isSelfClosing;
    }

    public HTMLTaggedElement setSelfClosing(boolean selfClosing) {
        isSelfClosing = selfClosing;
        return this;
    }

    public ArrayList<HTMLComment> getComments() {
        ArrayList<HTMLComment> comments = new ArrayList<>();
        for (HTMLElement comment : childElements) {
            if (comment instanceof HTMLComment) {
                comments.add((HTMLComment) comment);
            }
        }
        return comments;
    }

    public ArrayList<HTMLTextElement> getChildTextElements() {
        ArrayList<HTMLTextElement> elements = new ArrayList<>();
        for (HTMLElement element : childElements) {
            if (element instanceof HTMLTextElement) {
                elements.add((HTMLTextElement) element);
            }
        }
        return elements;
    }

    public ArrayList<HTMLTaggedElement> getChildElementsOfType(String tag) {
        ArrayList<HTMLTaggedElement> elements = new ArrayList<>();
        for (HTMLElement element : childElements) {
            if (element instanceof HTMLTaggedElement) {
                HTMLTaggedElement e = (HTMLTaggedElement) element;
                if (e.getTag().equals(tag)) {
                    elements.add(e);
                }
            }
        }
        return elements;
    }

    public ArrayList<HTMLTaggedElement> getChildElementsOfType(String tag, String attributeName, String attributeValue) {
        ArrayList<HTMLTaggedElement> elements = new ArrayList<>();
        for (HTMLElement element : childElements) {
            if (element instanceof HTMLTaggedElement) {
                HTMLTaggedElement e = (HTMLTaggedElement) element;
                if (e.getTag().equals(tag) && e.getAttribute(attributeName) != null
                        && e.getAttribute(attributeName).getValue().equals(attributeValue)) {
                    elements.add(e);
                }
            }
        }
        return elements;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indentation) {
        StringBuilder sb = new StringBuilder(repeat("    ", indentation));

        sb.append("<").append(tag);

        for (HTMLAttribute attrib : attributes) {
            sb.append(" ").append(attrib.toString());
        }

        sb.append(">\n");

        for (HTMLElement content : childElements) {
            sb.append(content.toString(indentation + 1));
        }

        if (!isSelfClosing) {
            sb.append(repeat("    ", indentation)).append("</").append(tag).append(">\n");
        }

        return sb.toString();
    }
}
