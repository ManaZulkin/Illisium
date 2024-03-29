package com.illisium.modelsDB.abylities;

import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;

@Entity
@Table(name = "weakness")
public class Weacness {

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Weacness());

    @Id
    private Long id;

    @Column(name = "name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
