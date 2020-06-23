package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Small extends HTMLElement {
    public Small() {
        super("small");
    }

    public Small(String textContent) {
        super("small");
        setText(textContent);
    }

    public Small setText(String text){
        setChildElement(text);
        return this;
    }
}
