package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Label extends HTMLElement {
    public Label() {
        super("label");
    }

    public Label(String textContent) {
        super("label");
        setText(textContent);
    }

    public Label setText(String text){
        setChildElement(text);
        return this;
    }
}
