package com.illisium.modelsDB.MultiID;

import java.io.Serializable;
import java.util.Objects;


public class IdArmor implements Serializable {

    private String name;
    private String type;

    public IdArmor() {
    }

    public IdArmor(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdArmor idArmor = (IdArmor) o;
        return Objects.equals(name, idArmor.name) && Objects.equals(type, idArmor.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
