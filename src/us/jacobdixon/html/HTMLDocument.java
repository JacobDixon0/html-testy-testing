package us.jacobdixon.html;

public class HTMLDocument {

    private HTMLTaggedElement doctypeIdentifier = new HTMLTaggedElement("!DOCTYPE");

    private HTMLTaggedElement html = new HTMLTaggedElement("html");
    private HTMLTaggedElement header = new HTMLTaggedElement("head");
    private HTMLTaggedElement title = new HTMLTaggedElement("title");
    private HTMLTaggedElement body = new HTMLTaggedElement("body");

    private HTMLTaggedElement style = new HTMLTaggedElement("style");
    private HTMLTaggedElement script = new HTMLTaggedElement("script");

    private HTMLTaggedElement icon = new HTMLTaggedElement("link").setAttribute("rel", "shortcut", "icon");

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
        for (HTMLTaggedElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
            if (element.getAttribute("href").getValue().equals(url)) {
                prexisting = true;
                break;
            }
        }
        if (!prexisting) {
            HTMLTaggedElement linkElement = new HTMLTaggedElement("link").
                    setAttribute("rel", "stylesheet")
                    .setAttribute("href", url)
                    .setAttribute("type", "text/css");
            header.addChildElements(linkElement);
        }
    }

    public void removeStylesheet(String url) {
        HTMLTaggedElement linkElement = null;
        for (HTMLTaggedElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
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
        for (HTMLTaggedElement element : header.getChildElementsOfType("link", "rel", "stylesheet")) {
            header.removeChildElement(element);
        }
    }

    public void addScript(String url) {
        boolean prexisting = false;
        for (HTMLTaggedElement element : header.getChildElementsOfType("script")) {
            if (element.getAttribute("src") != null && element.getAttribute("src").getValue().equals(url)) {
                prexisting = true;
                break;
            }
        }
        if (!prexisting) {
            HTMLTaggedElement scriptElement = new HTMLTaggedElement("script")
                    .setAttribute("src", url)
                    .setAttribute("type", "text/javascript");
            header.addChildElements(scriptElement);
        }
    }

    public void removeScript(String url) {
        HTMLTaggedElement scriptElement = null;
        for (HTMLTaggedElement element : header.getChildElementsOfType("script")) {
            if (element.getAttribute("src") != null && element.getAttribute("src").getValue().equals(url)) {
                scriptElement = element;
                break;
            }
        }
        if (scriptElement != null) {
            header.removeChildElement(scriptElement);
        }
    }

    public void setTitle(String title){
        this.title.clearChildElements();
        this.title.addChildElements(title);
    }

    public void setStyle(String style){
        this.style.clearChildElements();
        this.style.addChildElements(style);
        this.header.addChildElements(this.style);
    }

    public void setScript(String script){
        this.script.clearChildElements();
        this.script.addChildElements(script);
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

    public void clearScripts() {
        for (HTMLTaggedElement element : header.getChildElementsOfType("script")) {
            header.removeChildElement(element);
        }
    }

    public HTMLTaggedElement getDoctypeIdentifier() {
        return doctypeIdentifier;
    }

    public void setDoctypeIdentifier(HTMLTaggedElement doctypeIdentifier) {
        this.doctypeIdentifier = doctypeIdentifier;
    }

    public HTMLTaggedElement getHtml() {
        return html;
    }

    public void setHtml(HTMLTaggedElement html) {
        this.html = html;
    }

    public HTMLTaggedElement getHeader() {
        return header;
    }

    public void setHeader(HTMLTaggedElement header) {
        this.header = header;
    }

    public HTMLTaggedElement getTitle() {
        return title;
    }

    public void setTitle(HTMLTaggedElement title) {
        this.title = title;
    }

    public HTMLTaggedElement getBody() {
        return body;
    }

    public void setBody(HTMLTaggedElement body) {
        this.body = body;
    }

    public HTMLTaggedElement getStyle() {
        return style;
    }

    public void setStyle(HTMLTaggedElement style) {
        this.style = style;
    }

    public HTMLTaggedElement getScript() {
        return script;
    }

    public void setScript(HTMLTaggedElement script) {
        this.script = script;
    }

    @Override
    public String toString() {
        return doctypeIdentifier.toString() + html.toString();
    }
}
