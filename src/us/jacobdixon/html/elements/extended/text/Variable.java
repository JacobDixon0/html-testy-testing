package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Variable extends HTMLElement {
    public Variable() {
        super("var");
    }

    public Variable(String textContent) {
        super("var");
        setText(textContent);
    }

    public Variable setText(String text) {
        setChildElement(text);
        return this;
    }
}
