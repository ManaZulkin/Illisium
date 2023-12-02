package com.illisium.resources.creature;

import com.illisium.basic.Markers.Ability;

import java.io.Serializable;
import java.util.List;

public class CreatureAbility implements Serializable {
    private List<Ability> abilityList;

    public void addAbility(Ability ability){
        abilityList.add(ability);
    }

    public void removeAbility(Ability ability){
        abilityList.remove(ability);
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    public CreatureAbility() {
    }

    public CreatureAbility(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }
}
