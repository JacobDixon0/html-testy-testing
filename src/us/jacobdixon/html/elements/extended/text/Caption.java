package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Caption extends HTMLElement {
    public Caption() {
        super("caption");
    }

    public Caption(String textContent) {
        super("caption");
        setText(textContent);
    }

    public Caption setText(String text){
        setChildElement(text);
        return this;
    }
}
