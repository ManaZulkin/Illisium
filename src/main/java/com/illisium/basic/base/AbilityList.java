package com.illisium.basic.base;

import com.illisium.basic.Markers.Ability;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Passive;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.abylities.Special;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class contain list of all ability for this character/monster
 */

public class AbilityList  implements Serializable {
    private List<Ability> magickAbility;
    private List<Ability> physicalAbility;
    private List<Ability> passiveAbility;
    private List<Ability> specialAbility;

    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new ArrayList<>());




    public void learnAbility(Ability ability){
        if (ability.getClass() == Skills.class) physicalAbility.add(ability);
        if (ability.getClass() == Magick.class) magickAbility.add(ability);
        if (ability.getClass() == Passive.class) passiveAbility.add(ability);
        if (ability.getClass() == Special.class) specialAbility.add(ability);
    }

    public void forgetAbility(Ability ability){
        if (ability.getClass() == Skills.class) physicalAbility.remove(ability);
        if (ability.getClass() == Magick.class) magickAbility.remove(ability);
        if (ability.getClass() == Passive.class) passiveAbility.remove(ability);
        if (ability.getClass() == Special.class) specialAbility.remove(ability);
    }

    public List<Ability> getMagickAbility() {
        return magickAbility;
    }

    public void setMagickAbility(List<Ability> magickAbility) {
        this.magickAbility = magickAbility;
    }

    public List<Ability> getPhysicalAbility() {
        return physicalAbility;
    }

    public void setPhysicalAbility(List<Ability> physicalAbility) {
        this.physicalAbility = physicalAbility;
    }

    public List<Ability> getPassiveAbility() {
        return passiveAbility;
    }

    public void setPassiveAbility(List<Ability> passiveAbility) {
        this.passiveAbility = passiveAbility;
    }

    public List<Ability> getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(List<Ability> specialAbility) {
        this.specialAbility = specialAbility;
    }

    public AbilityList() {
        magickAbility = new ArrayList<Ability>();
        specialAbility =  new ArrayList<>();
        physicalAbility = new ArrayList<>();
        passiveAbility = new ArrayList<>();
    }
}
