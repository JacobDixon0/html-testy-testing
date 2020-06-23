package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Quote extends HTMLElement {
    public Quote() {
        super("q");
    }

    public Quote(String textContent) {
        super("q");
        setText(textContent);
    }

    public Quote setText(String text){
        setChildElement(text);
        return this;
    }
}
