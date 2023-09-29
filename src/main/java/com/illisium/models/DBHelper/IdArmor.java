package com.illisium.models.DBHelper;

import java.io.Serializable;
import java.util.Objects;


public class IdArmor implements Serializable {

    private String armorName;
    private String armorType;

    public IdArmor() {
    }

    public IdArmor(String armorName, String armorType) {
        this.armorName = armorName;
        this.armorType = armorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdArmor idArmor = (IdArmor) o;
        return Objects.equals(armorName, idArmor.armorName) && Objects.equals(armorType, idArmor.armorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(armorName, armorType);
    }
}
