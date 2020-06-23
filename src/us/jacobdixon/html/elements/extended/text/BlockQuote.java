package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class BlockQuote extends HTMLElement {
    public BlockQuote() {
        super("blockquote");
    }

    public BlockQuote(String textContent) {
        super("blockquote");
        setText(textContent);
    }

    public BlockQuote setText(String text){
        setChildElement(text);
        return this;
    }
}
