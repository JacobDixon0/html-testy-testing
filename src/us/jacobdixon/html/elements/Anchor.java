package us.jacobdixon.html.elements;

import us.jacobdixon.html.HTMLElement;

public class Anchor extends HTMLElement {

    enum ReferrerPolicy {
        NoReferrer, NoReferrerWhenDowngrade, Origin, OriginWhenCrossOrigin, UnsafeUrl;
    }

    enum Relation {
        Alternate, Author, Bookmark, External, Help, Licence, Next, NoFollow, NoReferrer, NoOpener, Prev, Search, Tag;
    }

    enum Target {
        Blank, Parent, Self, Top;
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

    public void setTextContents(String textContent){
        clearChildElements();
        addChildElement(textContent);
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
        switch (referrerPolicy) {
            case NoReferrer:
                setAttribute("referrerpolicy", "no-referrer");
                break;
            case NoReferrerWhenDowngrade:
                setAttribute("referrerpolicy", "no-referrer-when-downgrade");
                break;
            case Origin:
                setAttribute("referrerpolicy", "origin");
                break;
            case OriginWhenCrossOrigin:
                setAttribute("referrerpolicy", "origin-when-cross-origin");
                break;
            case UnsafeUrl:
                setAttribute("referrerpolicy", "unsafe-url");
                break;
        }
        return this;
    }

    public Anchor clearReferrerPolicy(){
        clearAttribute("referrerpolicy");
        return this;
    }

    public Anchor setRelation(Relation rel){
        switch (rel) {
            case Alternate:
                setAttribute("rel", "alternate");
                break;
            case Author:
                setAttribute("rel", "author");
                break;
            case Bookmark:
                setAttribute("rel", "bookmark");
                break;
            case External:
                setAttribute("rel", "external");
                break;
            case Help:
                setAttribute("rel", "help");
                break;
            case Licence:
                setAttribute("rel", "licence");
                break;
            case Next:
                setAttribute("rel", "next");
                break;
            case NoFollow:
                setAttribute("rel", "nofollow");
                break;
            case NoReferrer:
                setAttribute("rel", "norefferer");
                break;
            case NoOpener:
                setAttribute("rel", "noopener");
                break;
            case Prev:
                setAttribute("rel", "prev");
                break;
            case Search:
                setAttribute("rel", "search");
                break;
            case Tag:
                setAttribute("rel", "tag");
                break;

        }
        return this;
    }

    public Anchor clearRelation(){
        clearAttribute("rel");
        return this;
    }

    public Anchor setTarget(Target target){
        switch (target) {
            case Blank:
                setAttribute("target", "_blank");
                break;
            case Parent:
                setAttribute("target", "_parent");
                break;
            case Self:
                setAttribute("target", "_self");
                break;
            case Top:
                setAttribute("target", "_top");
                break;
        }
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
