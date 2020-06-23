package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class KeyboardInput extends HTMLElement {
    public KeyboardInput() {
        super("kbd");
    }

    public KeyboardInput(String textContent) {
        super("kbd");
        setText(textContent);
    }

    public KeyboardInput setText(String text){
        setChildElement(text);
        return this;
    }
}
