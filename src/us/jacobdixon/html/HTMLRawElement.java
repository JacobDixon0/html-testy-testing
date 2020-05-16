package us.jacobdixon.html;

import static us.jacobdixon.html.HTMLToolbox.sanitizeText;
import static us.jacobdixon.utils.StringToolbox.repeat;

public class HTMLRawElement implements HTMLAbstractElement {
    private String textContent;

    public HTMLRawElement(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String html(boolean useIndentation) {
        return html(useIndentation, 0);
    }

    public String html(boolean useIndentation, int indentation) {
        String s = "";
        if (useIndentation) s += repeat("    ", indentation);
        s += sanitizeText(textContent);
        if (useIndentation) s += "\n";
        return s;
    }
}
