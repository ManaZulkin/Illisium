package com.illisium.modelsDB.equpment;

import com.illisium.basic.Markers.Drop;
import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.base.Stats;
import com.illisium.modelsDB.MultiID.IdArmor;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Armor")
@IdClass(IdArmor.class)
public class Armor implements Serializable, IArmor, Drop {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Armor());

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Id
    @Column(name = "armor_Name")
    private String name = "empty";

    @Column(name = "rare")
    private String rare = "";
    @Id
    @Column(name = "armor_Type")
    private String type = "";

    @Transient
    private Stats stats;

    public Armor() {
    }

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + id +
                ", armorName='" + name + '\'' +
                ", rare='" + rare + '\'' +
                ", armorType='" + type + '\'' +
                ", stats=" + stats +
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

    public void setName(String armorName) {
        this.name = armorName;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getType() {
        return type;
    }

    public void setType(String armorType) {
        this.type = armorType;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Armor(String name, String rare, String type, Stats stats) {
        this.name = name;
        this.rare = rare;
        this.type = type;
        this.stats = stats;
    }

}
