package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Abbreviation extends HTMLElement {
    public Abbreviation() {
        super("abbr");
    }

    public Abbreviation(String textContent) {
        super("abbr");
        setText(textContent);
    }

    public Abbreviation setText(String text){
        setChildElement(text);
        return this;
    }
}
