package com.illisium.modelsDB.session;

import com.illisium.basic.Markers.Creature;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Battle implements Serializable {
    private static final long serialVersionUID = DataUtility.getSerialForClass(new Battle());

    private Map<Creature, Boolean> aliesList = new HashMap<>();
    private Map<Creature, Boolean> enemiesList = new HashMap<>();
    private Map<Creature, String> statusList = new HashMap<>();

    public void addAlies(Creature creature) {
        aliesList.put(creature, true);
    }

    public void addEnemies(Creature creature) {
        enemiesList.put(creature, true);
    }

    public void kill(Creature creature) {
        if (aliesList.get(creature)) {
            aliesList.put(creature, false);
        }else {
            enemiesList.put(creature, false);
        }
    }

    public void rise(Creature creature) {
        if (aliesList.get(creature)) {
            aliesList.put(creature, true);
        }else {
            enemiesList.put(creature, true);
        }
    }

    public void cleanBattle(){
        aliesList.clear();
        enemiesList.clear();
    }

    public void changeCreatureSide(Creature creature) {
        if (aliesList.get(creature)) {
            aliesList.remove(creature, true);
            enemiesList.put(creature, true);
        }else {
            enemiesList.remove(creature,true);
            aliesList.put(creature, false);
        }
    }

    public void addStatus(Creature creature, String status) {
        statusList.put(creature, status);
    }

    public void removeStatus(Creature creature, String status) {
        statusList.remove(creature, status);
    }


}
