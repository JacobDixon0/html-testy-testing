package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Strong extends HTMLElement {
    public Strong() {
        super("strong");
    }

    public Strong(String textContent) {
        super("strong");
        setText(textContent);
    }

    public Strong setText(String text){
        setChildElement(text);
        return this;
    }
}
