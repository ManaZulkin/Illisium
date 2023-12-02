package com.illisium.resources.creature;

import com.illisium.basic.Markers.Drop;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CreatureDrop implements Serializable {
    private Map<Double, Drop> dropList;

    public void addToDrop(Drop drop, Double droprate){
        dropList.put(droprate, drop);
    }

    public void removeFromDrop(Drop drop, Double droprate){
        dropList.remove(droprate, drop);
    }

    public Map<Double, Drop> getDropList() {
        return dropList;
    }

    public void setDropList(Map<Double, Drop> dropList) {
        this.dropList = dropList;
    }

    public CreatureDrop() {
    }

    public CreatureDrop(Map<Double, Drop> dropList) {
        this.dropList = dropList;
    }
}
