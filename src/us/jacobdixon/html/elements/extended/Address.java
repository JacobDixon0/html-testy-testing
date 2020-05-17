package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Address extends HTMLElement {
    public Address() {
        super("address");
    }

    public Address(String textContent) {
        super("address");
        setText(textContent);
    }

    public Address setText(String text){
        setChildElement(text);
        return this;
    }
}
