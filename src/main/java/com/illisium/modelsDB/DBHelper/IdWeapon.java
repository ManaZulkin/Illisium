package com.illisium.modelsDB.DBHelper;

import java.io.Serializable;
import java.util.Objects;

public class IdWeapon implements Serializable {
    private String weaponName;
    private String weaponType;

    public IdWeapon() {
    }

    public IdWeapon(String weapon_name, String weaponType) {
        this.weaponName = weapon_name;
        this.weaponType = weaponType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdWeapon idWeapon = (IdWeapon) o;
        return Objects.equals(weaponName, idWeapon.weaponName) && Objects.equals(weaponType, idWeapon.weaponType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponName, weaponType);
    }
}
