package com.illisium.modelsDB.abylities;

import com.illisium.basic.Markers.Ability;
import com.illisium.modelsDB.MultiID.IdSkill;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@IdClass(IdSkill.class)
@Table(name = "Skills")
public class Skills implements Serializable, Ability {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Skills());


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @Column(name = "skill_Name")
    private String name;

    @Column(name = "weapon")
    private String weapon;

    @Id
    @Column(name = "clas")
    private String clas;

    @Column(name = "description")
    private String description;

    @Column(name = "damage")
    private double damage;

    @Column(name = "effect")
    private String effect;

    @Column(name = "Cooldown")
    private int cooldown;

    @Column(name = "lvl")
    private int lvl;

    @Column(name = "style")
    private String style;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String skillName) {
        this.name = skillName;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skillName='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", clas='" + clas + '\'' +
                ", description='" + description + '\'' +
                ", damage=" + damage +
                ", effect='" + effect + '\'' +
                ", cooldown=" + cooldown +
                ", lvl=" + lvl +
                ", style='" + style + '\'' +
                '}';
    }

    public Skills(String name, String weapon, String clas, String description, double damage, String effect, int cooldown, int lvl, String style) {
        this.name = name;
        this.weapon = weapon;
        this.clas = clas;
        this.description = description;
        this.damage = damage;
        this.effect = effect;
        this.cooldown = cooldown;
        this.lvl = lvl;
        this.style = style;
    }

    public Skills() {
    }
}
