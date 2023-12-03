package com.illisium.modelsDB.DBHelper;

import java.io.Serializable;
import java.util.Objects;

public class IdMagick implements Serializable {
    private String name;
    private String element;
    private int lvl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdMagick idMagick = (IdMagick) o;
        return lvl == idMagick.lvl && Objects.equals(name, idMagick.name) && Objects.equals(element, idMagick.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lvl, element);
    }

    public IdMagick() {
    }

    public IdMagick(String name, String element, int lvl) {
        this.name = name;
        this.element = element;
        this.lvl = lvl;
    }
}
