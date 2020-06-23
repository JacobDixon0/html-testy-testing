package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class FigureCaption extends HTMLElement {
    public FigureCaption() {
        super("figcaption");
    }

    public FigureCaption(String textContent) {
        super("figcaption");
        setText(textContent);
    }

    public FigureCaption setText(String text){
        setChildElement(text);
        return this;
    }
}
