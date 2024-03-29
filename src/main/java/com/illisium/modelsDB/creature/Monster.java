package com.illisium.modelsDB.creature;

import com.illisium.basic.base.*;
import com.illisium.modelsDB.MultiID.IdMonster;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Monsters")
@IdClass(IdMonster.class)
public class Monster implements Serializable {

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Monster());
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Id
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "type")
    private String type;
    @Column(name = "ownership")
    private String ownership;
    @Column(name = "Lvl")
    private int lvl;

    private Stats stats;
    private ArmorSet armorSet;
    private JewellerySet jewellerySet;
    private AbilityList abilityList;
    public Weakness weakness ;


    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ownership='" + ownership + '\'' +
                ", armorSet=" + armorSet +
                ", jewellerySet=" + jewellerySet +
                ", abilityList=" + abilityList +
                ", weakness=" + weakness +
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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public ArmorSet getArmorSet() {
        return armorSet;
    }

    public void setArmorSet(ArmorSet armorSet) {
        this.armorSet = armorSet;
    }

    public JewellerySet getJewellerySet() {
        return jewellerySet;
    }

    public void setJewellerySet(JewellerySet jewellerySet) {
        this.jewellerySet = jewellerySet;
    }

    public AbilityList getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(AbilityList abilityList) {
        this.abilityList = abilityList;
    }

    public Weakness getWeakness() {
        return weakness;
    }

    public void setWeakness(Weakness weakness) {
        this.weakness = weakness;
    }

    public void addWeakness(String weacness){
        weakness.getWeaknessList().add(weacness);
    }

    public void removeWeakness(String weakness){
        this.weakness.getWeaknessList().remove(weakness);
    }
    public Monster(String name, String type, String ownership, int lvl, Stats stats, ArmorSet armorSet, JewellerySet jewellerySet, AbilityList abilityList, Weakness weakness) {
        this.name = name;
        this.type = type;
        this.ownership = ownership;
        this.lvl = lvl;
        this.stats = stats;
        this.armorSet = armorSet;
        this.jewellerySet = jewellerySet;
        this.abilityList = abilityList;
        this.weakness = weakness;
    }

    public Monster() {
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
