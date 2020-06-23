package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Insert extends HTMLElement {
    public Insert() {
        super("figcaption");
    }

    public Insert(String textContent) {
        super("figcaption");
        setText(textContent);
    }

    public Insert setText(String text){
        setChildElement(text);
        return this;
    }
}
