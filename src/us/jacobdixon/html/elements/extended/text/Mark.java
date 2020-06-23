package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Mark extends HTMLElement {
    public Mark() {
        super("mark");
    }

    public Mark(String textContent) {
        super("mark");
        setText(textContent);
    }

    public Mark setText(String text){
        setChildElement(text);
        return this;
    }
}
