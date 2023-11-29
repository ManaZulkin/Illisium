package com.illisium.models.DBHelper;

import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

import java.io.Serializable;
import java.util.Objects;

public class IdSkill implements Serializable {
    private String skillName;
    private String clas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdSkill idSkill = (IdSkill) o;
        return Objects.equals(skillName, idSkill.skillName) && Objects.equals(clas, idSkill.clas);
    }

    public IdSkill() {
    }

    public IdSkill(String skillName, String clas) {
        this.skillName = skillName;
        this.clas = clas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName, clas);
    }
}
