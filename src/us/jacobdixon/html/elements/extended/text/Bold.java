package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Bold extends HTMLElement {
    public Bold() {
        super("b");
    }

    public Bold(String textContent) {
        super("b");
        setText(textContent);
    }

    public Bold setText(String text) {
        setChildElement(text);
        return this;
    }
}
