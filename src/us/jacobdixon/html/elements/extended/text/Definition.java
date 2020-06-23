package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Definition extends HTMLElement {
    public Definition() {
        super("dfn");
    }

    public Definition(String textContent) {
        super("dfn");
        setText(textContent);
    }

    public Definition setText(String text){
        setChildElement(text);
        return this;
    }
}
