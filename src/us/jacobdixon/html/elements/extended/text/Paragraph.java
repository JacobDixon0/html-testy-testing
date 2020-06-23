package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Paragraph extends HTMLElement {
    public Paragraph() {
        super("p");
    }

    public Paragraph(String textContent) {
        super("p");
        setText(textContent);
    }

    public Paragraph setText(String text){
        setChildElement(text);
        return this;
    }
}
