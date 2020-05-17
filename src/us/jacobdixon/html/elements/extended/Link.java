package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Link extends HTMLElement {

    public enum CrossOrigin {
        Anonymous("anonymous"),
        UseCredentials("use-credentials");

        private final String crossOrigin;

        CrossOrigin(String crossOrigin) {
            this.crossOrigin = crossOrigin;
        }

        @Override
        public String toString() {
            return crossOrigin;
        }
    }

    public enum Relation {
        Alternate("alternate"),
        Author("author"),
        DNSPrefetch("dns-prefetch"),
        Help("help"),
        Icon("icon"),
        Licence("licence"),
        Next("next"),
        PingBack("pingback"),
        Preconnect("preconnect"),
        Prefetch("prefetch"),
        Preload("preload"),
        Prerender("prerender"),
        Prev("prev"),
        Search("search"),
        Stylesheet("stylesheet");

        private final String relation;

        Relation(String relation) {
            this.relation = relation;
        }

        @Override
        public String toString() {
            return relation;
        }
    }

    public Link() {
        super("link");
    }

    public Link(Relation relation, String href) {
        super("link");
        setRelation(relation);
        setHREF(href);
    }

    public Link setCrossOrigin(CrossOrigin crossOrigin) {
        setAttribute("crossorigin", crossOrigin.toString());
        return this;
    }

    public Link clearCrossOrigin() {
        clearAttribute("crossorigin");
        return this;
    }

    public Link setHREF(String href) {
        setAttribute("href", href);
        return this;
    }

    public Link clearHREF() {
        clearAttribute("href");
        return this;
    }

    public Link setHREFLang(String hrefLang) {
        setAttribute("hreflang", hrefLang);
        return this;
    }

    public Link clearHREFLang() {
        clearAttribute("hreflang");
        return this;
    }

    public Link setMedia(String media) {
        setAttribute("media", media);
        return this;
    }

    public Link clearMedia() {
        clearAttribute("media");
        return this;
    }

    public Link setReferrerPolicy(ReferrerPolicy referrerPolicy) {
        setAttribute("referrerpolicy", referrerPolicy.toString());
        return this;
    }

    public Link setRelation(Relation rel) {
        setAttribute("rel", rel.toString());
        return this;
    }

    /**
     * For use with rel=icon
     *
     * @param sizes height x width | any
     * @return this
     */
    public Link setSizes(String sizes) {
        setAttribute("sizes", sizes);
        return this;
    }

    /**
     * For use with rel=icon
     *
     * @return this
     */
    public Link clearSizes() {
        clearAttribute("sizes");
        return this;
    }

    public Link setType(String type) {
        setAttribute("type", type);
        return this;
    }

    public Link clearType() {
        clearAttribute("type");
        return this;
    }
}
