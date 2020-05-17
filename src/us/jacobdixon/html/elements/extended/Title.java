package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Title extends HTMLElement {
    public Title() {
        super("title");
    }

    public Title(String title) {
        super("title");
        setTitle(title);
    }

    public Title setTitle(String title){
        setChildElement(title);
        return this;
    }
}
