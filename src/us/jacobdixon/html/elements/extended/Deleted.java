package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Deleted extends HTMLElement {
    public Deleted() {
        super("del");
    }

    public Deleted(String textContent) {
        super("del");
        setText(textContent);
    }

    public Deleted setText(String text){
        setChildElement(text);
        return this;
    }
}
