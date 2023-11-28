package com.illisium.basic.IMPL;

import com.illisium.basic.base.InfoEquip;
import com.illisium.basic.base.Stats;
import com.illisium.basic.INTERFACE.IWeapon;

public class Weapon implements IWeapon {
    private Stats stats;
    private InfoEquip info;

    public Weapon() {
    }

    public Weapon(Stats stats, InfoEquip info) {
        this.stats = stats;
        this.info = info;
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
