package us.jacobdixon.html;

import static us.jacobdixon.html.HTMLToolbox.sanitizeText;
import static us.jacobdixon.utils.StringToolbox.repeat;

public class HTMLTextElement implements HTMLElement {
    private String textContent;

    public HTMLTextElement(String textContent){
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indentation){
        return repeat("    ", indentation) + sanitizeText(textContent) + "\n";
    }
}
