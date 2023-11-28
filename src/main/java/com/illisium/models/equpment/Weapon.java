package com.illisium.models.equpment;

import com.illisium.basic.INTERFACE.IWeapon;
import com.illisium.models.DBHelper.IdWeapon;
import jakarta.persistence.*;

@Entity
@IdClass(IdWeapon.class)
@Table(name = "weapon")
public class Weapon implements IWeapon {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Id
    @Column(name = "weapon_Name")
    private String weaponName;
    @Column(name = "rare")
    String rare;
    @Id
    @Column(name = "weapon_Type")
    private String weaponType;

    @Column(name = "DMG")
    int damage;
    @Column(name = "durability")
    int durability = 10;
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

    public Weapon() {
    }

    public Weapon(String weaponName, String weaponType) {
        this.weaponName = weaponName;
        this.weaponType = weaponType;
    }

    public Weapon(String weaponName, String rare, String weaponType, int damage, int durability, int strange, int intelligent, int agility, int charisma, int luck, int stamina) {
        this.weaponName = weaponName;
        this.rare = rare;
        this.weaponType = weaponType;
        this.damage = damage;
        this.durability = durability;
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", weaponName='" + weaponName + '\'' +
                ", rare='" + rare + '\'' +
                ", weaponType='" + weaponType + '\'' +
                ", damage=" + damage +
                ", durability=" + durability +
                ", strange=" + strange +
                ", intelligent=" + intelligent +
                ", agility=" + agility +
                ", charisma=" + charisma +
                ", luck=" + luck +
                ", stamina=" + stamina +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weapon_Name) {
        this.weaponName = weapon_Name;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weapon_Type) {
        this.weaponType = weapon_Type;
    }

    public int getDurability() {
        return durability;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
}
