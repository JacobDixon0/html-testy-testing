package us.jacobdixon.html;

import us.jacobdixon.html.elements.Body;
import us.jacobdixon.html.elements.Head;

import java.util.ArrayList;

public class HTMLDocument {

    private HTMLElement doctypeIdentifier = new HTMLElement("!DOCTYPE");

    private HTMLElement html = new HTMLElement("html");
    private HTMLElement header = new HTMLElement("head");
    private HTMLElement body = new HTMLElement("body");

    private HTMLElement title = new HTMLElement("title");

    private HTMLElement style = new HTMLElement("style");
    private HTMLElement script = new HTMLElement("script");

    private HTMLElement icon = new HTMLElement("link").setAttribute("rel", "shortcut", "icon");

    private HTMLDocument() {
    }

    public static HTMLDocument getDefault() {
        HTMLDocument document = new HTMLDocument();

        document.doctypeIdentifier.setAttribute("html");

        document.html.addChildElements(document.header
                .addChildElements(document.title))
                .addChildElements(document.body);

        return document;
    }

    public void addStylesheet(String url) {
        boolean prexisting = false;
        for (HTMLElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
            if (element.getAttribute("href").getValue().equals(url)) {
                prexisting = true;
                break;
            }
        }
        if (!prexisting) {
            HTMLElement linkElement = new HTMLElement("link").
                    setAttribute("rel", "stylesheet")
                    .setAttribute("href", url)
                    .setAttribute("type", "text/css");
            header.addChildElements(linkElement);
        }
    }

    public void removeStylesheet(String url) {
        HTMLElement linkElement = null;
        for (HTMLElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
            if (element.getAttribute("href").getValue().equals(url)) {
                linkElement = element;
                break;
            }
        }
        if (linkElement != null) {
            header.removeChildElement(linkElement);
        }
    }

    public void clearStylesheets() {
        for (HTMLElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
            header.removeChildElement(element);
        }
    }

    public void addScript(String url) {
        boolean prexisting = false;
        for (HTMLElement element : header.getChildElementsOfType("script")) {
            if (element.getAttribute("src") != null && element.getAttribute("src").getValue().equals(url)) {
                prexisting = true;
                break;
            }
        }
        if (!prexisting) {
            HTMLElement scriptElement = new HTMLElement("script")
                    .setAttribute("src", url)
                    .setAttribute("type", "text/javascript");
            header.addChildElements(scriptElement);
        }
    }

    public void removeScript(String url) {
        HTMLElement scriptElement = null;
        for (HTMLElement element : header.getChildElementsOfType("script")) {
            if (element.getAttribute("src") != null && element.getAttribute("src").getValue().equals(url)) {
                scriptElement = element;
                break;
            }
        }
        if (scriptElement != null) {
            header.removeChildElement(scriptElement);
        }
    }

    public void clearScripts() {
        for (HTMLElement element : header.getChildElementsOfType("script")) {
            header.removeChildElement(element);
        }
    }

    public void setTitle(String title){
        this.title.setChildElement(title);
    }

    public void setStyle(String style){
        this.style.setChildElement(style);
        this.header.addChildElements(this.style);
    }

    public void setScript(String script){
        this.script.setChildElement(script);
        this.header.addChildElements(this.script);
    }

    public void setIcon(String url, String type){
        this.icon.setAttribute("href", url).setAttribute("type", type);
        this.header.addChildElements(this.icon);
    }

    public void setIcon(String url){
        this.icon.setAttribute("href", url);
        this.header.addChildElements(this.icon);
    }

    public void clearIcon(){
        this.header.removeChildElement(icon);
    }

    public void clearStyle(){
        this.header.removeChildElement(style);
    }

    public void clearScript(){
        this.header.removeChildElement(script);
    }

    public HTMLElement getDoctypeIdentifier() {
        return doctypeIdentifier;
    }

    public void setDoctypeIdentifier(HTMLElement doctypeIdentifier) {
        this.doctypeIdentifier = doctypeIdentifier;
    }

    public HTMLElement getHtml() {
        return html;
    }

    public void setHtml(HTMLElement html) {
        this.html = html;
    }

    public HTMLElement getHeader() {
        return header;
    }

    public void setHeader(Head header) {
        this.header = header;
    }

    public HTMLElement getTitle() {
        return title;
    }

    public void setTitle(HTMLElement title) {
        this.title = title;
    }

    public HTMLElement getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public HTMLElement getStyle() {
        return style;
    }

    public void setStyle(HTMLElement style) {
        this.style = style;
    }

    public HTMLElement getScript() {
        return script;
    }

    public void setScript(HTMLElement script) {
        this.script = script;
    }

    public String html() {
        return doctypeIdentifier.html(true) + html.html(true);
    }

    public String html(boolean useIndentation) {
        return doctypeIdentifier.html(useIndentation) + html.html(useIndentation);
    }
}
