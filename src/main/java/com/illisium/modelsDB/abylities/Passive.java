package com.illisium.modelsDB.abylities;

import com.illisium.basic.Markers.Ability;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;

public class Passive implements Serializable, Ability {
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Passive());
}
