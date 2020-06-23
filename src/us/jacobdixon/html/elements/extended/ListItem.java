package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLAbstractElement;
import us.jacobdixon.html.HTMLElement;

import java.util.Collection;

public class ListItem extends HTMLElement {
    public ListItem() {
        super("li");
    }

    public ListItem(HTMLAbstractElement childElement) {
        super("li");
        setChildElement(childElement);
    }

    public ListItem(HTMLAbstractElement... childElements) {
        super("li");
        setChildElements(childElements);
    }

    public ListItem(Collection<HTMLAbstractElement> childElements) {
        super("li");
        setChildElements(childElements);
    }

    public ListItem(String textContent) {
        super("li");
        setChildElement(textContent);
    }
}
