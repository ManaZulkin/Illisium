package com.illisium.resources.creature;

import com.illisium.basic.base.Stats;

import java.io.Serializable;

public class CreatureInfo implements Serializable {
    private String creatureName;
    private String ownership;
    private Stats stats;

    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
