package us.jacobdixon.html;

public abstract class HTML {
    public static HTMLElement tag(String tag){
        return new HTMLElement(tag);
    }
}
