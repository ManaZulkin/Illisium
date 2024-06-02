package com.illisium.modelsDB.creature;

import com.illisium.basic.Markers.Creature;
import com.illisium.basic.Markers.INPC;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;

public class NPC implements Serializable, INPC, Creature {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new NPC());

    private String name;


    @Override
    public String getName() {
        return name;
    }
}
