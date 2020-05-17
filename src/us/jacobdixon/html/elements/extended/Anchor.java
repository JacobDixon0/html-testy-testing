package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Anchor extends HTMLElement {

    public enum Relation {
        Alternate("alternate"),
        Author("author"),
        Bookmark("bookmark"),
        External("external"),
        Help("help"),
        Licence("licence"),
        Next("next"),
        NoFollow("nofollow"),
        NoReferrer("noreferrer"),
        NoOpener("noopener"),
        Prev("prev"),
        Search("search"),
        Tag("tag");

        private final String relation;

        Relation(String relation) {
            this.relation = relation;
        }

        @Override
        public String toString() {
            return relation;
        }
    }

    public enum Target {
        Blank("_blank"),
        Parent("_parent"),
        Self("_self"),
        Top("_top");

        private final String target;

        Target(String target) {
            this.target = target;
        }

        @Override
        public String toString() {
            return target;
        }
    }

    public Anchor() {
        super("a");
    }

    public Anchor(String href) {
        super("a");
        setHREF(href);
    }

    public Anchor(String href, Target target) {
        super("a");
        setHREF(href);
        setTarget(target);
    }

    public Anchor(String href, Target target, boolean download) {
        super("a");
        setHREF(href);
        setTarget(target);
        setDownload(download);
    }

    public Anchor(String href, boolean download) {
        super("a");
        setHREF(href);
        setDownload(download);
    }

    public Anchor setText(String textContent){
        setChildElement(textContent);
        return this;
    }

    public Anchor setDownload(boolean useDownload) {
        if (useDownload) {
            setAttribute("download");
        } else {
            clearAttribute("download");
        }
        return this;
    }

    public Anchor setHREF(String href) {
        setAttribute("href", href);
        return this;
    }

    public Anchor clearHREF() {
        clearAttribute("href");
        return this;
    }

    public Anchor setHREFLang(String hrefLang) {
        setAttribute("hreflang", hrefLang);
        return this;
    }

    public Anchor clearHREFLang() {
        clearAttribute("hreflang");
        return this;
    }

    public Anchor setPing(String... urls) {
        setAttribute("ping", urls);
        return this;
    }

    public Anchor clearPing() {
        clearAttribute("ping");
        return this;
    }

    public Anchor setReferrerPolicy(ReferrerPolicy referrerPolicy) {
        setAttribute("referrerpolicy", referrerPolicy.toString());
        return this;
    }

    public Anchor clearReferrerPolicy(){
        clearAttribute("referrerpolicy");
        return this;
    }

    public Anchor setRelation(Relation rel){
        setAttribute("rel", rel.toString());
        return this;
    }

    public Anchor clearRelation(){
        clearAttribute("rel");
        return this;
    }

    public Anchor setTarget(Target target){
        setAttribute("target", target.toString());
        return this;
    }

    public Anchor setTarget(String frameName){
        setAttribute("target", frameName);
        return this;
    }

    public Anchor clearTarget(){
        clearAttribute("target");
        return this;
    }

    public Anchor setType(String type){
        setAttribute("type", type);
        return this;
    }

    public Anchor clearType(){
        clearAttribute("type");
        return this;
    }

}
