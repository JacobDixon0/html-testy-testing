package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Emphasized extends HTMLElement {
    public Emphasized() {
        super("emphasized");
    }

    public Emphasized(String textContent) {
        super("emphasized");
        setText(textContent);
    }

    public Emphasized setText(String text){
        setChildElement(text);
        return this;
    }
}
