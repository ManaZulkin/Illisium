package com.illisium.modelsDB.creature;

import com.illisium.basic.base.Stats;

import java.util.Random;

/**
 * Class contains methods for help to generate creature of any type
 */
public class CreatureCreatorHelper {

    private final static Random random = new Random();


    public static Stats getStatsFromLvl(int lvl){
        Stats stats = new Stats();
        int temp = 0;
        while (lvl > 0) {
            if (stats.getStrange() == 0){
                stats.setStrange(temp);
            }
        }

        return stats;
    }

}
