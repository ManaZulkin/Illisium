package com.illisium.modelsDB.equpment;

import com.illisium.basic.Markers.IWeapon;
import com.illisium.basic.base.Stats;
import com.illisium.modelsDB.DBHelper.IdWeapon;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@IdClass(IdWeapon.class)
@Table(name = "weapon")
public class Weapon implements IWeapon, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Id
    @Column(name = "weapon_Name")
    private String name;
    @Column(name = "rare")
    String rare;
    @Id
    @Column(name = "weapon_Type")
    private String type;

    @Column(name = "DMG")
    int damage;

    private Stats stats;

    public Weapon() {
    }

    public Weapon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", weaponName='" + name + '\'' +
                ", rare='" + rare + '\'' +
                ", weaponType='" + type + '\'' +
                ", damage=" + damage +
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

    public void setName(String weaponName) {
        this.name = weaponName;
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

    public void setType(String weaponType) {
        this.type = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
