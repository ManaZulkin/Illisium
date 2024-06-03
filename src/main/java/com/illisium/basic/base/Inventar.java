package com.illisium.basic.base;

import com.illisium.modelsDB.equpment.Item;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventar implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(Item item) {
        return items.get(items.indexOf(item));
    }
}
