package com.illisium.models.armor;

import com.illisium.bin.INT.IArmor;



public class DBArmor implements IArmor {

    int id;
    String name;
    String rare;
    String type;
    int   durability ;
    int strange;
    int intelligent;
    int agility;
    int charisma;
    int luck;
    int stamina;

    public DBArmor() {
    }

    public DBArmor(String name, String rare, String type, int durability, int strange, int intelligent, int agility, int charisma, int luck, int stamina) {
        this.name = name;
        this.rare = rare;
        this.type = type;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setType(String type) {
        this.type = type;
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
}
