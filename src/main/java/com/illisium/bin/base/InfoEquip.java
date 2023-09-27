package com.illisium.bin.base;

public class InfoEquip {
    private String type, name, rare;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public InfoEquip() {
    }

    public InfoEquip(String type, String name, String rare) {
        this.type = type;
        this.name = name;
        this.rare = rare;
    }
}
