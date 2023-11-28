package com.illisium.models.equpment;

import com.illisium.models.DBHelper.IdArmor;
import jakarta.persistence.*;

@Entity
@Table(name = "Armor")
@IdClass(IdArmor.class)
public class Armor {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Id
    @Column(name = "armor_Name")
    private String armorName;
    @Column(name = "rare")
    String rare;
    @Id
    @Column(name = "armor_Type")
    private String armorType;
    @Column(name = "durability")
    int   durability = 10;
    @Column(name = "strange")
    int strange;

    @Column(name = "intelligent")
    int intelligent;
    @Column(name = "agility")
    int agility;
    @Column(name = "charisma")
    int charisma;
    @Column(name = "luck")
    int luck;
    @Column(name = "stamina")
    int stamina;

    public Armor() {
    }

    public Armor(int id, String name, String rare, String type, int durability, int strange, int intelligent, int agility, int charisma, int luck, int stamina) {
        this.id = id;
        this.armorName = name;
        this.rare = rare;
        this.armorType = type;
        this.durability = durability;
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return armorName;
    }

    public void setName(String name) {
        this.armorName = name;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getType() {
        return armorType;
    }

    public void setType(String type) {
        this.armorType = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getStrange() {
        return strange;
    }

    public void setStrange(int strange) {
        this.strange = strange;
    }

    public int getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(int intelligent) {
        this.intelligent = intelligent;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + id +
                ", armorName='" + armorName + '\'' +
                ", rare='" + rare + '\'' +
                ", armorType='" + armorType + '\'' +
                ", durability=" + durability +
                ", strange=" + strange +
                ", intelligent=" + intelligent +
                ", agility=" + agility +
                ", charisma=" + charisma +
                ", luck=" + luck +
                ", stamina=" + stamina +
                '}';
    }
}
