package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Preformatted extends HTMLElement {
    public Preformatted() {
        super("pre");
    }

    public Preformatted(String textContent) {
        super("pre");
        setText(textContent);
    }

    public Preformatted setText(String text){
        setChildElement(text);
        return this;
    }
}
