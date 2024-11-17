package com.illisium.resources.mechaniks;

import com.illisium.modelsDB.creature.Character;

public class StatsTo {

    public static int helth(Character character){
        return character.getBasicStats().getStamina() * 8;
    }
}
