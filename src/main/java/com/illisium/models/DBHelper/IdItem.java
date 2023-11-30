package com.illisium.models.DBHelper;

import java.io.Serializable;
import java.util.Objects;

public class IdItem implements Serializable {

    private String itemName;
    private String itemType;

    @Override
    public String toString() {
        return "IdItem{" +
                "itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdItem idItem = (IdItem) o;
        return Objects.equals(itemName, idItem.itemName) && Objects.equals(itemType, idItem.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemType);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public IdItem(String itemName, String itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public IdItem() {
    }
}
