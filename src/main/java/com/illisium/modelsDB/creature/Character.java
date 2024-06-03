package com.illisium.modelsDB.creature;

import com.illisium.basic.Markers.Creature;
import com.illisium.basic.Markers.ICharacter;
import com.illisium.basic.base.*;
import com.illisium.basic.base.sub.Classes;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "characters")
public class Character implements Serializable, Creature, ICharacter {

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Character());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "name")
    private String name;

    @Transient
    private InfoChar infoChar = new InfoChar();

    @Transient
    private Classes classes;

    @Transient
    private  Stats stats = new Stats();

    @Transient
    private  AbilityList abilities  = new AbilityList();

    @Transient
    private  Equipment equipment = new Equipment();

    @Transient
    private  Inventar inventory = new Inventar();


    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void setAbilities(AbilityList abilities) {
        this.abilities = abilities;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setInventory(Inventar inventory) {
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoChar getInfoChar() {
        return infoChar;
    }

    public void setInfoChar(InfoChar infoChar) {
        this.infoChar = infoChar;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Stats getStats() {
        return stats;
    }

    public AbilityList getAbilities() {
        return abilities;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Inventar getInventory() {
        return inventory;
    }
}
