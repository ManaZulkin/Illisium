package com.illisium.basic.base;

import com.illisium.basic.Markers.IArmor;
import com.illisium.basic.en.ArmorType;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArmorSet implements Serializable {
    private final Map<String, IArmor> armorSet;


    public void equip(@org.jetbrains.annotations.NotNull @NotNull IArmor armor) throws RuntimeException
    {
        if (armorSet.containsKey(armor.getType())){
            armorSet.replace(armor.getType(), armor );
        } else {
            throw new RuntimeException("Wrong item");
        }
    }

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

    private ArmorSet() {
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
}
