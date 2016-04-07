package com.company;

/**
 * Created by travis on 3/31/16.
 */
public class Player extends ListItem {

    public Player(String value) {
        super(value);
    }

    @Override
    public int compare(ListItem listItem) {
        if(this.getValue().equals(listItem.getValue())) {
            return 0;
        } else if(this.getValue().compareTo(listItem.getValue()) < 0) {
            return -1;
        } else if(this.getValue().compareTo(listItem.getValue()) > 0) {
            return 1;
        } return 10;
    }

    @Override
    public boolean hasNextItem() {
        return this.getNextItem() != null;
    }

    @Override
    public boolean hasPrevItem() {
        return this.getPrevItem() != null;
    }

}

