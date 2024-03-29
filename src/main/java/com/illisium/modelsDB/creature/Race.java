package com.illisium.modelsDB.creature;


import com.illisium.resources.utilit.DataUtility;
import jakarta.persistence.*;

import java.io.Serial;

@Entity
@Table(name = "Race")

public class Race {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Race());

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
