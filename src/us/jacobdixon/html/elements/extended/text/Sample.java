package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class Sample extends HTMLElement {
    public Sample() {
        super("samp");
    }

    public Sample(String textContent) {
        super("samp");
        setText(textContent);
    }

    public Sample setText(String text){
        setChildElement(text);
        return this;
    }
}
