package com.illisium.modelsDB.abylities;

import com.illisium.modelsDB.DBHelper.IdMagick;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "magick")
@IdClass(IdMagick.class)
public class Magick {

    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @Column(name = "spell_Name")
    private String spellName;

    @Id
    @Column(name = "element")
    private String element;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "effect")
    private String effect;

    @Column(name = "cd")
    private int cd;

    @Id
    @Column(name = "lvl")
    private int lvl;

    @Column(name = "distance")
    private String range;

    @Column(name = "damage")
    private int damage;

    public Magick() {
    }

    public Magick(String spellName, String element, int lvl) {
        this.spellName = spellName;
        this.element = element;
        this.lvl = lvl;
    }

    public Magick(String spellName, String element, String type, String description, String effect, int cd, int lvl, String range, int damage) {
        this.spellName = spellName;
        this.element = element;
        this.type = type;
        this.description = description;
        this.effect = effect;
        this.cd = cd;
        this.lvl = lvl;
        this.range = range;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Magick{" +
                "id=" + id +
                ", name='" + spellName + '\'' +
                ", element='" + element + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", effect='" + effect + '\'' +
                ", cd=" + cd +
                ", lvl=" + lvl +
                ", range='" + range + '\'' +
                ", damage=" + damage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String name) {
        this.spellName = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}