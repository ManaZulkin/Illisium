package com.illisium.modelsDB.equpment;

import com.illisium.basic.Markers.Drop;
import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.Markers.IWeapon;
import com.illisium.modelsDB.MultiID.IdItem;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Item")
@IdClass(IdItem.class)

public class Item implements Serializable, Drop, IWeapon, IArmor {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Item());

    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "item_Name")
    private String name;

    @Id
    @Column(name = "item_Type")
    private String type;

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
                ", itemName='" + name + '\'' +
                ", itemType='" + type + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        this.name = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String itemType) {
        this.type = itemType;
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

    public Item(String name, String type, boolean usable, boolean stackable, String description) {
        this.name = name;
        this.type = type;
        this.usable = usable;
        this.stackable = stackable;
        this.description = description;
    }

    public Item() {
    }
}
