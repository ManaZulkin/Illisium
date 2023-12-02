package com.illisium.resources.creature;

import com.illisium.basic.Markers.IMonster;

import java.io.Serializable;

public class Creature implements IMonster, Serializable {
    private CreatureAbility creatureAbility;
    private CreatureDrop creatureDrop;
    private CreatureEquip creatureEquip;
    private CreatureInfo creatureInfo;

    public Creature(CreatureAbility creatureAbility, CreatureDrop creatureDrop, CreatureEquip creatureEquip, CreatureInfo creatureInfo) {
        this.creatureAbility = creatureAbility;
        this.creatureDrop = creatureDrop;
        this.creatureEquip = creatureEquip;
        this.creatureInfo = creatureInfo;
    }

    public Creature() {
    }

    public CreatureAbility getCreatureAbility() {
        return creatureAbility;
    }

    public void setCreatureAbility(CreatureAbility creatureAbility) {
        this.creatureAbility = creatureAbility;
    }

    public CreatureDrop getCreatureDrop() {
        return creatureDrop;
    }

    public void setCreatureDrop(CreatureDrop creatureDrop) {
        this.creatureDrop = creatureDrop;
    }

    public CreatureEquip getCreatureEquip() {
        return creatureEquip;
    }

    public void setCreatureEquip(CreatureEquip creatureEquip) {
        this.creatureEquip = creatureEquip;
    }

    public CreatureInfo getCreatureInfo() {
        return creatureInfo;
    }

    public void setCreatureInfo(CreatureInfo creatureInfo) {
        this.creatureInfo = creatureInfo;
    }
}
