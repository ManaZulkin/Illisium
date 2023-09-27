package com.illisium.bin.IMPL;

import com.illisium.bin.INT.IArmor;
import com.illisium.bin.base.InfoEquip;
import com.illisium.bin.base.Stats;

public class Armor implements IArmor {
    private InfoEquip info;
    private Stats stats;

    public Armor() {
    }

    public Armor(InfoEquip info, Stats stats) {
        this.info = info;
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public InfoEquip getInfo() {
        return info;
    }

    public void setInfo(InfoEquip info) {
        this.info = info;
    }
}
