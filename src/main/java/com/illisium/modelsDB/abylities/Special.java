package com.illisium.modelsDB.abylities;

import com.illisium.basic.Markers.Ability;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;

public class Special implements Serializable, Ability {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Special());

    @Override
    public String getName() {
        return "";
    }
}
