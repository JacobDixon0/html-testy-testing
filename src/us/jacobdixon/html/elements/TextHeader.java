package us.jacobdixon.html.elements;

import us.jacobdixon.html.HTMLElement;

public class TextHeader extends HTMLElement {
    public TextHeader() {
        super("h1");
    }

    public TextHeader(int level) {
        super("h" + level);
        if (level < 1 || level > 6) throw new IllegalArgumentException("Invalid header level \"h" + level + "\"");
    }
}
