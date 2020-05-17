package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Superscript extends HTMLElement {
    public Superscript() {
        super("superscript");
    }

    public Superscript(String textContent) {
        super("superscript");
        setText(textContent);
    }

    public Superscript setText(String text){
        setChildElement(text);
        return this;
    }
}
