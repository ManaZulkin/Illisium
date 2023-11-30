package com.illisium.models.equpment;

import com.illisium.models.DBHelper.IdItem;
import jakarta.persistence.*;

@Entity
@Table(name = "Item")
@IdClass(IdItem.class)
public class Item {

    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "item_Name")
    private String itemName;

    @Id
    @Column(name = "item_Type")
    private String itemType;

    @Column(name = "usable")
    private boolean usable;

    @Column(name = "stackable")
    private boolean stackable;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", usable=" + usable +
                ", stackable=" + stackable +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String itemName, String itemType, boolean usable, boolean stackable, String description) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.usable = usable;
        this.stackable = stackable;
        this.description = description;
    }

    public Item() {
    }
}
