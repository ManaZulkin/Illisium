package com.illisium.basic.base;

import java.io.Serializable;
import java.util.List;

public class Weakness implements Serializable {
    private List<String> weaknessList;

    @Override
    public String toString() {
        return "Weakness{" +
                "weaknessList=" + weaknessList +
                '}';
    }

    public List<String> getWeaknessList() {
        return weaknessList;
    }

    public void setWeaknessList(List<String> weaknessList) {
        this.weaknessList = weaknessList;
    }

    public Weakness() {
    }

    public Weakness(List<String> weaknessList) {
        this.weaknessList = weaknessList;
    }
}
