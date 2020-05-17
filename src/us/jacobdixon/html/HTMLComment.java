package us.jacobdixon.html;

public class HTMLComment implements HTMLAbstractElement {

    String content;

    public HTMLComment(String content) {
        this.content = content;
    }

    public String html(){
        return html(false);
    }

    public String html(boolean useIndentation) {
        return html(useIndentation, 0);
    }

    public String html(boolean useIndentation, int indentation) {
        String s = "";
        if (useIndentation) s += "    ".repeat(indentation);
        s += "<!-- " + content + " -->";
        if (useIndentation) s += "\n";
        return s;
    }
}
