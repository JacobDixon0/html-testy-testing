package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Meta extends HTMLElement {
    public enum HTTPEquiv {
        ContentType("content-type"),
        DefaultStyle("default-style"),
        Refresh("refresh");

        private final String httpEquiv;

        HTTPEquiv(String httpEquiv) {
            this.httpEquiv = httpEquiv;
        }

        @Override
        public String toString() {
            return httpEquiv;
        }
    }

    public enum Name {
        ApplicationName("application-name"),
        Author("author"),
        Description("description"),
        Generator("generator"),
        Keywords("keywords"),
        Viewport("viewport");

        private final String name;

        Name(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public Meta() {
        super("meta");
    }

    public Meta(Name name) {
        super("meta");
        setName(name);
    }

    public Meta(String content) {
        super("meta");
        setContent(content);
    }

    public Meta(Name name, String content) {
        super("meta");
        setName(name);
        setContent(content);
    }

    public Meta setCharset(String charset) {
        setAttribute("charset", charset);
        return this;
    }

    public Meta clearCharset() {
        clearAttribute("charset");
        return this;
    }

    public Meta setContent(String content) {
        setAttribute("content", content);
        return this;
    }

    public Meta clearContent() {
        clearAttribute("content");
        return this;
    }

    public Meta setHTTPEquiv(HTTPEquiv httpEquiv) {
        setAttribute("http-equiv", httpEquiv.toString());
        return this;
    }

    public Meta clearHTTPEquiv() {
        clearAttribute("http-equiv");
        return this;
    }

    public Meta setName(Name name) {
        setAttribute("name", name.toString());
        return this;
    }

    public Meta clearName() {
        clearAttribute("name");
        return this;
    }

    public Meta setProperty(String property) {
        setAttribute("property", property);
        return this;
    }

    public Meta clearProperty() {
        clearAttribute("property");
        return this;
    }
}
