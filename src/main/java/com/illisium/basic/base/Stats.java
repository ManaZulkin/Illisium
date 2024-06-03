package com.illisium.basic.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Stats implements Serializable {
    int strange, intelligent, agility, charisma, luck, stamina, durability ;


    private Map<String, Integer> stats = new HashMap<String, Integer>();

    public Stats() {
        stats.put("strange", strange);
        stats.put("intelligent", intelligent);
        stats.put("agility", agility);
        stats.put("charisma", charisma);
        stats.put("luck", luck);
        stats.put("stamina", stamina);
    }

    public Stats(int strange, int intelligent, int agility, int charisma, int luck, int stamina) {
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
        stats.put("strange", strange);
        stats.put("intelligent", intelligent);
        stats.put("agility", agility);
        stats.put("charisma", charisma);
        stats.put("luck", luck);
        stats.put("stamina", stamina);
    }

    public Stats(int strange, int intelligent, int agility, int charisma, int luck, int stamina, int durability) {
        this.strange = strange;
        this.intelligent = intelligent;
        this.agility = agility;
        this.charisma = charisma;
        this.luck = luck;
        this.stamina = stamina;
        this.durability = durability;
        stats.put("strange", strange);
        stats.put("intelligent", intelligent);
        stats.put("agility", agility);
        stats.put("charisma", charisma);
        stats.put("luck", luck);
        stats.put("stamina", stamina);
        stats.put("durability", durability);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "strange=" + strange +
                ", intelligent=" + intelligent +
                ", agility=" + agility +
                ", charisma=" + charisma +
                ", luck=" + luck +
                ", stamina=" + stamina +
                ", durability=" + durability +
                '}';
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

    public Map<String, Integer> getStats() {
        return stats;
    }
    public String[] getStatNames() {

        return stats.keySet().toArray(new String[stats.size()]);
    }
    public Integer[] getStatValues() {
        return stats.values().toArray(new Integer[stats.size()]);
    }

}
