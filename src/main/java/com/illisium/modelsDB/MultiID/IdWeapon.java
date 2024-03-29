package com.illisium.modelsDB.MultiID;

import java.io.Serializable;
import java.util.Objects;

public class IdWeapon implements Serializable {
    private String name;
    private String type;

    public IdWeapon() {
    }

    public IdWeapon(String weapon_name, String type) {
        this.name = weapon_name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdWeapon idWeapon = (IdWeapon) o;
        return Objects.equals(name, idWeapon.name) && Objects.equals(type, idWeapon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
