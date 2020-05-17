package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

public class Time extends HTMLElement {
    public Time() {
        super("time");
    }

    public Time(String textContent) {
        super("time");
        setText(textContent);
    }

    public Time setText(String time){
        setChildElement(time);
        return this;
    }
}
