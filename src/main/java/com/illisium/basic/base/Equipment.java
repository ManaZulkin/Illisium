package com.illisium.basic.base;

import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.Markers.IWeapon;
import com.illisium.modelsDB.equpment.Artifact;

import java.io.Serializable;

public class Equipment implements Serializable {
    private IWeapon LeftHand, RightHand, ExtraWeapon;
    private ArmorSet armorSet;
    private JewellerySet jewellerySet;
    private Artifact artifact;

}
