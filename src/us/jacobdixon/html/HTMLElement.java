package us.jacobdixon.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static us.jacobdixon.html.HTML.sanitizeValue;

public class HTMLElement implements HTMLAbstractElement {

    private String tag;
    private ArrayList<HTMLAttribute> attributes = new ArrayList<>();
    private ArrayList<HTMLAbstractElement> childElements = new ArrayList<>();
    private boolean isSelfClosing;

    public HTMLElement(String tag) {
        this.tag = tag;
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

    public HTMLElement clearAttributes() {
        attributes.clear();
        return this;
    }

    public HTMLElement setChildElement(String textContent) {
        childElements.clear();
        childElements.add(new HTMLRawElement(textContent));
        return this;
    }

    public HTMLElement setChildElement(HTMLAbstractElement element) {
        childElements.clear();
        childElements.add(element);
        return this;
    }

    public HTMLElement addChildElements(Collection<HTMLAbstractElement> elements) {
        this.childElements.addAll(elements);
        return this;
    }

    public HTMLElement addChildElements(String... textContents) {
        for (String s : textContents) {
            this.childElements.add(new HTMLRawElement(s));
        }
        return this;
    }

    public HTMLElement addChildElements(HTMLAbstractElement... elements) {
        this.childElements.addAll(Arrays.asList(elements));
        return this;
    }

    public HTMLElement addChildElement(String textContent) {
        this.childElements.add(new HTMLRawElement(textContent));
        return this;
    }

    public HTMLElement addChildElement(HTMLAbstractElement element) {
        this.childElements.add(element);
        return this;
    }

    public HTMLElement removeChildElement(HTMLAbstractElement element) {
        childElements.remove(element);
        return this;
    }

    public HTMLElement removeChildElements(Collection<HTMLAbstractElement> elements) {
        this.childElements.removeAll(elements);
        return this;
    }

    public HTMLElement removeChildElements(HTMLAbstractElement... elements) {
        this.childElements.removeAll(Arrays.asList(elements));
        return this;
    }

    public HTMLElement setChildElements(HTMLAbstractElement... elements) {
        this.childElements.clear();
        this.childElements.addAll(Arrays.asList(elements));
        return this;
    }

    public HTMLElement setChildElements(Collection<HTMLAbstractElement> elements) {
        this.childElements.clear();
        this.childElements.addAll(elements);
        return this;
    }

    public HTMLElement clearChildElements() {
        childElements.clear();
        return this;
    }

    public HTMLElement addComment(String comment) {
        childElements.add(new HTMLComment(comment));
        return this;
    }

    public HTMLElement addComment(HTMLComment comment) {
        childElements.add(comment);
        return this;
    }

    public HTMLElement removeComment(HTMLComment comment) {
        childElements.remove(comment);
        return this;
    }

    public HTMLElement clearComments() {
        for (HTMLComment comment : getComments()) {
            childElements.remove(comment);
        }
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

    public HTMLElement setHidden(boolean hidden) {
        if (hidden) {
            setAttribute("hidden");
        } else {
            clearAttribute("hidden");
        }
        return this;
    }

    public HTMLElement setStyle(String style) {
        setAttribute("style", style);
        return this;
    }

    public HTMLElement clearStyle() {
        clearAttribute("style");
        return this;
    }

    public HTMLElement setTitle(String title) {
        setAttribute("title", title);
        return this;
    }

    public HTMLElement clearTitle() {
        clearAttribute("title");
        return this;
    }

    public HTMLElement setLang(String lang) {
        setAttribute("lang", lang);
        return this;
    }

    public HTMLElement clearLang() {
        clearAttribute("lang");
        return this;
    }

    public HTMLElement setData(String key, String value) {
        setAttribute("data-" + key, value);
        return this;
    }

    public String getData(String key) {
        return getAttribute("data-" + key).getValue();
    }

    public ArrayList<HTMLAttribute> getData() {
        ArrayList<HTMLAttribute> dataAttributes = new ArrayList<>();
        for (HTMLAttribute attrib : attributes) {
            if (attrib.getKey().startsWith("data-")) dataAttributes.add(attrib);
        }
        return dataAttributes;
    }

    public HTMLElement clearData(String key) {
        clearAttribute("data-" + key);
        return this;
    }

    public HTMLElement clearData() {
        attributes.removeIf(attrib -> attrib.getKey().startsWith("data-"));
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

    public HTMLElement setChildElements(ArrayList<HTMLAbstractElement> childElements) {
        this.childElements = childElements;
        return this;
    }

    public boolean isSelfClosing() {
        return isSelfClosing;
    }

    public HTMLElement setSelfClosing(boolean selfClosing) {
        isSelfClosing = selfClosing;
        return this;
    }

    public ArrayList<HTMLAbstractElement> getChildElements() {
        return childElements;
    }

    public ArrayList<HTMLAbstractElement> getChildElements(boolean cascading) {
        ArrayList<HTMLAbstractElement> elements = getChildElements();

        if (cascading) {
            for (HTMLAbstractElement element : elements) {
                if (element instanceof HTMLElement) {
                    elements.addAll(((HTMLElement) element).getChildElements(true));
                }
            }
        }
        return elements;
    }

    public ArrayList<HTMLComment> getComments() {
        ArrayList<HTMLComment> comments = new ArrayList<>();
        for (HTMLAbstractElement comment : childElements) {
            if (comment instanceof HTMLComment) {
                comments.add((HTMLComment) comment);
            }
        }
        return comments;
    }

    public ArrayList<HTMLRawElement> getChildTextElements() {
        ArrayList<HTMLRawElement> elements = new ArrayList<>();
        for (HTMLAbstractElement element : childElements) {
            if (element instanceof HTMLRawElement) {
                elements.add((HTMLRawElement) element);
            }
        }
        return elements;
    }

    public ArrayList<HTMLElement> getChildHTMLElements() {
        ArrayList<HTMLElement> elements = new ArrayList<>();
        for (HTMLAbstractElement element : childElements) {
            if (element instanceof HTMLElement) {
                elements.add((HTMLElement) element);
            }
        }
        return elements;
    }

    public ArrayList<HTMLElement> getChildElementsOfType(String tag) {
        ArrayList<HTMLElement> elements = new ArrayList<>();
        for (HTMLAbstractElement element : childElements) {
            if (element instanceof HTMLElement) {
                HTMLElement e = (HTMLElement) element;
                if (e.getTag().equals(tag)) {
                    elements.add(e);
                }
            }
        }
        return elements;
    }

    public ArrayList<HTMLElement> getChildElementsOfType(String tag, String attributeName, String attributeValue) {
        ArrayList<HTMLElement> elements = new ArrayList<>();
        for (HTMLElement element : getChildElementsOfType(tag)) {
            if (element.getAttribute(attributeName) != null
                    && element.getAttribute(attributeName).getValue().equals(attributeValue)) {
                elements.add(element);
            }
        }
        return elements;
    }

    public String html() {
        return html(false);
    }

    public String html(boolean useIndentation) {
        return html(useIndentation, 0);
    }

    public String html(boolean useIndentation, int indentation) {
        StringBuilder sb = new StringBuilder();
        if (useIndentation) sb.append("    ".repeat(indentation));

        sb.append("<").append(tag);
        for (HTMLAttribute attrib : attributes) sb.append(" ").append(attrib.toString());
        sb.append(">");
        if (useIndentation) sb.append("\n");

        for (HTMLAbstractElement content : childElements) {
            sb.append(content.html(useIndentation, indentation + 1));
        }

        if (!isSelfClosing) {
            if (useIndentation) sb.append("    ".repeat(indentation));
            sb.append("</").append(tag).append(">");
            if (useIndentation) sb.append("\n");
        }

        return sb.toString();
    }
}
