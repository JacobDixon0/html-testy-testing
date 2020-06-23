package us.jacobdixon.html.elements.extended.text;

import us.jacobdixon.html.HTMLElement;

public class TextHeader extends HTMLElement {
    public TextHeader() {
        super("h1");
    }

    public TextHeader(String textContent) {
        super("h1");
        setChildElement(textContent);
    }

    public TextHeader(int level) {
        super("h" + level);
        if (level < 1 || level > 6) throw new IllegalArgumentException("Invalid header level \"h" + level + "\"");
    }

    public TextHeader(int level, String textContent) {
        super("h" + level);
        if (level < 1 || level > 6) throw new IllegalArgumentException("Invalid header level \"h" + level + "\"");
        setChildElement(textContent);
    }

    public TextHeader setText(String text){
        setChildElement(text);
        return this;
    }
}
