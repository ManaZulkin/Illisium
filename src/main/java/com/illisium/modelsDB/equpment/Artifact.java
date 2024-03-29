package com.illisium.modelsDB.equpment;

import com.illisium.basic.Markers.Drop;
import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.Markers.IWeapon;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;

public class Artifact implements Serializable, Drop, IArmor, IWeapon {

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new Artifact());
    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
