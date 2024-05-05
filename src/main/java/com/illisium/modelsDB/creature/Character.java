package com.illisium.modelsDB.creature;

import com.illisium.basic.Markers.Creature;
import com.illisium.basic.Markers.ICharacter;
import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "characters")
public class Character implements Serializable, Creature, ICharacter {

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Character());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "name")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
