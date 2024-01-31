package com.illisium.modelsDB.creature;


import jakarta.persistence.*;

@Entity
@Table(name = "Race")

public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    public String name;

////    @Column(name = "weeknes")
////    @OneToMany(mappedBy = "weakness")
//    public Set<Weacness> weaknessSet;

}
