package us.jacobdixon.html;

import static us.jacobdixon.html.HTMLToolbox.sanitizeText;

public class HTMLTextContent implements HTMLContent {
    private String content;

    public HTMLTextContent(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return sanitizeText(content);
    }
}
