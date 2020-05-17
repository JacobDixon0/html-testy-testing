package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLAbstractElement;
import us.jacobdixon.html.HTMLElement;

import java.util.ArrayList;
import java.util.Collection;

public class Div extends HTMLElement {
    public Div() {
        super("div");
    }

    public Div(HTMLAbstractElement childElement) {
        super("div");
        setChildElement(childElement);
    }

    public Div(HTMLAbstractElement... childElements) {
        super("div");
        setChildElements(childElements);
    }

    public Div(Collection<HTMLAbstractElement> childElements) {
        super("div");
        setChildElements(childElements);
    }

}
