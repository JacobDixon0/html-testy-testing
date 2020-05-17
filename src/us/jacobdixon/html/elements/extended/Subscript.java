package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Subscript extends HTMLElement {
    public Subscript() {
        super("subscript");
    }

    public Subscript(String textContent) {
        super("subscript");
        setText(textContent);
    }

    public Subscript setText(String text){
        setChildElement(text);
        return this;
    }
}
