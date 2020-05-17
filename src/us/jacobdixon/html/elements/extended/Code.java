package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Code extends HTMLElement {
    public Code() {
        super("code");
    }

    public Code(String textContent) {
        super("code");
        setText(textContent);
    }

    public Code setText(String text){
        setChildElement(text);
        return this;
    }
}
