package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Details extends HTMLElement {
    public Details() {
        super("details");
    }

    public Details(String textContent) {
        super("details");
        setText(textContent);
    }

    public Details setText(String text){
        setChildElement(text);
        return this;
    }
}
