package com.company;

/**
 * Created by travis on 3/31/16.
 */
public abstract class ListItem {

    private ListItem nextItem;
    private ListItem prevItem;
    private String value;

    public ListItem(String value) {
        this.prevItem = null;
        this.nextItem = null;
        this.value = value;
    }

    abstract int compare(ListItem listItem);
    abstract boolean hasNextItem();
    abstract boolean hasPrevItem();

    public ListItem moveToNextItem() {
        return this.nextItem;
    }

    public ListItem moveToPrevItem() {
        return this.prevItem;
    }

    public ListItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(ListItem nextItem) {
        this.nextItem = nextItem;
    }

    public ListItem getPrevItem() {
        return prevItem;
    }

    public void setPrevItem(ListItem prevItem) {
        this.prevItem = prevItem;
    }

    public String getValue() {
        return value;
    }



}
