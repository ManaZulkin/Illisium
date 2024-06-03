package com.illisium.basic.base.sub;

import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.en.ArmorType;
import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArmorSet implements Serializable {
    private final Map<String, IArmor> armorSet;


    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new ArmorSet());


    /**
     * method take object IArmor end check if this item one of element of armor set
     * if it's true - put new element of armor to armor set
     * @param armor
     * @throws RuntimeException
     */
    public void equip( IArmor armor) throws RuntimeException
    {
        if(armor == null){

        }else if (armorSet.containsKey(armor.getType())){
            armorSet.replace(armor.getType(), armor );
        } else {
            throw new RuntimeException("Wrong item");
        }
    }

    /**
     * replace element of armor with name st with null element
     * if st is not key, then check armor set for name of armor element, and if true - replace with null element
     * @param st
     * @throws RuntimeException
     */
    public void unequipped(String st) throws RuntimeException{
        if(armorSet.containsKey(st)){
            armorSet.replace(st, null);
        }else if (nameCheckInSet(st)){
            Set<Map.Entry<String, IArmor>> set = armorSet.entrySet();
            for (Map.Entry<String, IArmor> stringIArmorEntry : set) {
                if (stringIArmorEntry.getValue().getName().equalsIgnoreCase(st)){
                    armorSet.replace(stringIArmorEntry.getKey(), null);
                    break;
                }
            }
        }else throw new RuntimeException("This item not equipped!");
    }

    /**
     * creating empty armor set
     */
    public ArmorSet() {
        this.armorSet = new HashMap<>();
        this.armorSet.put(ArmorType.CHEST.name(), null);
        this.armorSet.put(ArmorType.GLOVES.name(), null);
        this.armorSet.put(ArmorType.BOOTS.name(), null);
        this.armorSet.put(ArmorType.PANTS.name(), null);
        this.armorSet.put(ArmorType.HEAD.name(), null);
        this.armorSet.put(ArmorType.BELT.name(), null);
        this.armorSet.put(ArmorType.LEGGINGS.name(), null);
        this.armorSet.put(ArmorType.HANDCUFFS.name(), null);
        this.armorSet.put(ArmorType.SHIRT.name(), null);

    }

    @Override
    public String toString() {
        return "ArmorSet{" +
                "armorSet=" + armorSet +
                '}';
    }


    public boolean nameCheckInSet(String name){
        Set<Map.Entry<String, IArmor>> set = armorSet.entrySet();
        for (Map.Entry<String, IArmor> stringIArmorEntry : set) {
            if (stringIArmorEntry.getValue().getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public String getEqipedName(String type){
        if(armorSet.containsKey(type)) {
            if (armorSet.get(type) == null){
                return "empty";
            }
            return armorSet.get(type).getName();
        }else return "empty";
    }

    public Map<String, IArmor> getArmorSet() {
        return armorSet;
    }
}
