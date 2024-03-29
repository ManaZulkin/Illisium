package com.illisium.modelsDB.MultiID;

import java.io.Serializable;
import java.util.Objects;

public class IdMonster implements Serializable {
    private String name;
    private String type;

    @Override
    public String toString() {
        return "IdMonster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IdMonster idMonster = (IdMonster) object;
        return Objects.equals(name, idMonster.name) && Objects.equals(type, idMonster.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public IdMonster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public IdMonster() {
    }
}
