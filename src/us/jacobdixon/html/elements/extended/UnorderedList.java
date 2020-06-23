package us.jacobdixon.html.elements.extended;

import us.jacobdixon.html.HTMLElement;

import java.util.ArrayList;
import java.util.Collection;

public class UnorderedList extends HTMLElement {
    public UnorderedList() {
        super("ul");
    }

    public UnorderedList(ListItem... listItems) {
        super("ul");
        addChildElements(listItems);
    }

    public UnorderedList(Collection<ListItem> listItems) {
        super("ul");
        listItems.forEach(this::addChildElement);
    }

    public ArrayList<ListItem> getItems() {
        ArrayList<ListItem> items = new ArrayList<>();
        for (HTMLElement element : getChildElementsOfType("li")) {
            items.add((ListItem) element);
        }
        return items;
    }

    public ListItem getItem(int index) {
        return (ListItem) getChildElementsOfType("li").get(index);
    }

    public UnorderedList addItem(ListItem item) {
        addChildElement(item);
        return this;
    }

    public UnorderedList addItem(int index, ListItem item) {
        getChildElements().add(index, item);
        return this;
    }

    public UnorderedList addItems(ListItem... items) {
        addChildElements(items);
        return this;
    }

    public UnorderedList addItems(Collection<ListItem> items) {
        items.forEach(this::addChildElement);
        return this;
    }

    public UnorderedList removeItem(ListItem item) {
        removeChildElement(item);
        return this;
    }

    public UnorderedList removeItem(int index) {
        removeItem(getItem(index));
        return this;
    }

    public UnorderedList removeItems(ListItem... items) {
        removeChildElements(items);
        return this;
    }

    public UnorderedList removeItems(Collection<ListItem> items) {
        items.forEach(this::removeChildElement);
        return this;
    }

}
