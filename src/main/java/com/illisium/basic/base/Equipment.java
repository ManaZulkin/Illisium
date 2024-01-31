package com.illisium.basic.base;

import com.illisium.basic.Markers.IWeapon;
import com.illisium.modelsDB.equpment.Artifact;

import java.io.Serializable;

/**
    this class contain only that equipment, which character/monster wear on
    does not show which weapon in use right now
 **/
public class Equipment implements Serializable {
    private IWeapon LeftHand, RightHand, DoubleWeapon;
    private ArmorSet armorSet;
    private JewellerySet jewellerySet;
    private Artifact artifact;


    public Equipment() {
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "LeftHand=" + LeftHand +
                ", RightHand=" + RightHand +
                ", ExtraWeapon=" + DoubleWeapon +
                ", armorSet=" + armorSet +
                ", jewellerySet=" + jewellerySet +
                ", artifact=" + artifact +
                '}';
    }
    
    public IWeapon getLeftHand() {
        return LeftHand;
    }

    public void setLeftHand(IWeapon leftHand) {
        LeftHand = leftHand;
    }

    public IWeapon getRightHand() {
        return RightHand;
    }

    public void setRightHand(IWeapon rightHand) {
        RightHand = rightHand;
    }

    public IWeapon getDoubleWeapon() {
        return DoubleWeapon;
    }

    public void setDoubleWeapon(IWeapon doubleWeapon) {
        DoubleWeapon = doubleWeapon;
    }

    public ArmorSet getArmorSet() {
        return armorSet;
    }

    public void setArmorSet(ArmorSet armorSet) {
        this.armorSet = armorSet;
    }

    public JewellerySet getJewellerySet() {
        return jewellerySet;
    }

    public void setJewellerySet(JewellerySet jewellerySet) {
        this.jewellerySet = jewellerySet;
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
}
