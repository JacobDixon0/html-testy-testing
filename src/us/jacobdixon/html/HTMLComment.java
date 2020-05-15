package us.jacobdixon.html;

import static us.jacobdixon.utils.StringToolbox.repeat;

public class HTMLComment implements HTMLElement{

    String content;

    public HTMLComment(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indentation) {
        return repeat("    ", indentation) + "<!-- " + content + "-->\n";
    }
}
