package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Citation extends HTMLElement {
    public Citation() {
        super("cite");
    }

    public Citation(String textContent) {
        super("cite");
        setText(textContent);
    }

    public Citation setText(String text){
        setChildElement(text);
        return this;
    }
}
