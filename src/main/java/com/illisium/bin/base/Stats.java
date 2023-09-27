package com.illisium.bin.base;

public class Stats {
    int strange, intelligent, agility, charisma, luck, stamina, durability ;

    public Stats() {
    }

    public Stats(int strange, int intelligent, int agility, int charisma, int luck, int stamina) {
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
    }

    public Stats(int strange, int intelligent, int agility, int charisma, int luck, int stamina, int durability) {
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
        this.durability = durability;
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
