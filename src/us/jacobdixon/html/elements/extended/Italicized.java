package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Italicized extends HTMLElement {
    public Italicized() {
        super("i");
    }

    public Italicized(String textContent) {
        super("i");
        setText(textContent);
    }

    public Italicized setText(String text){
        setChildElement(text);
        return this;
    }
}
