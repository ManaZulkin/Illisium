package com.illisium.basic.IMPL;

import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.base.InfoEquip;
import com.illisium.basic.base.Stats;

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
