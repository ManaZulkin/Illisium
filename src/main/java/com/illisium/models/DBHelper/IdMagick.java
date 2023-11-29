package com.illisium.models.DBHelper;

import java.io.Serializable;
import java.util.Objects;

public class IdMagick implements Serializable {
    private String spellName;
    private String element;
    private int lvl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdMagick idMagick = (IdMagick) o;
        return lvl == idMagick.lvl && Objects.equals(spellName, idMagick.spellName) && Objects.equals(element, idMagick.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spellName, lvl, element);
    }

    public IdMagick() {
    }

    public IdMagick(String spellName, String element, int lvl) {
        this.spellName = spellName;
        this.element = element;
        this.lvl = lvl;
    }
}
