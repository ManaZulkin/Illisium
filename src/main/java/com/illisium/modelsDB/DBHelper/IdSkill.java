package com.illisium.modelsDB.DBHelper;

import java.io.Serializable;
import java.util.Objects;

public class IdSkill implements Serializable {
    private String name;
    private String clas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdSkill idSkill = (IdSkill) o;
        return Objects.equals(name, idSkill.name) && Objects.equals(clas, idSkill.clas);
    }

    public IdSkill() {
    }

    public IdSkill(String name, String clas) {
        this.name = name;
        this.clas = clas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clas);
    }
}
