package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Summary extends HTMLElement {
    public Summary() {
        super("summary");
    }

    public Summary(String textContent) {
        super("summary");
        setText(textContent);
    }

    public Summary setText(String text){
        setChildElement(text);
        return this;
    }
}
