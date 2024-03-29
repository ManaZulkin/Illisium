package com.illisium.modelsDB.MultiID;

import java.io.Serializable;
import java.util.Objects;

public class IdItem implements Serializable {

    private String name;
    private String type;

    @Override
    public String toString() {
        return "IdItem{" +
                "itemName='" + name + '\'' +
                ", itemType='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdItem idItem = (IdItem) o;
        return Objects.equals(name, idItem.name) && Objects.equals(type, idItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public IdItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public IdItem() {
    }
}
