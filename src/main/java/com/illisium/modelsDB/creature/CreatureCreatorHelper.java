package com.illisium.modelsDB.creature;

import com.illisium.basic.base.AbilityList;
import com.illisium.basic.base.Equipment;
import com.illisium.basic.base.Stats;
import com.illisium.basic.en.ClassType;
import com.illisium.config.repositories.*;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Class contains methods for help to generate creature of any type
 */
@Component
public class CreatureCreatorHelper {
    private final ArmorRepository armorRepository;
    private final MagickRepository magickRepository;
    private final SkillsRepository skillsRepository;
    private final WeaponRepository weaponRepository;
    private final ItemRepository itemRepository;

    private final static Random random = new Random();

    public CreatureCreatorHelper(ArmorRepository armorRepository, MagickRepository magickRepository, SkillsRepository skillsRepository, WeaponRepository weaponRepository, ItemRepository itemRepository) {
        this.armorRepository = armorRepository;
        this.magickRepository = magickRepository;
        this.skillsRepository = skillsRepository;
        this.weaponRepository = weaponRepository;
        this.itemRepository = itemRepository;
    }


    public static Stats getStatsFromLvl(int lvl){
        Stats stats = new Stats();
        int temp = 0;
        while (lvl > 0) {
            if (stats.getStrange() == 0){
                stats.setStrange(temp);
            }
        }

        return stats;
    }

    public  Equipment getBasicEquipmentForCharacterByClass(String className){
        Equipment equipment = new Equipment();
        if (className.equals(ClassType.Mage.name())){
            equipment.getArmorSet().equip(armorRepository.findByName("Mage robe"));
            equipment.getArmorSet().equip(armorRepository.findByName("Mage pants"));
            equipment.getArmorSet().equip(armorRepository.findByName("Normal boots"));
        }

        if (className.equals(ClassType.Archer.name())){
            equipment.getArmorSet().equip(armorRepository.findByName("Old Leather chest"));
            equipment.getArmorSet().equip(armorRepository.findByName("Old Leather Pants"));
            equipment.getArmorSet().equip(armorRepository.findByName("Normal boots"));
        }

        if (className.equals(ClassType.Lancer.name()) ||
                className.equals(ClassType.Swordsman.name())){
            equipment.getArmorSet().equip(armorRepository.findByName("Comon chest"));
            equipment.getArmorSet().equip(armorRepository.findByName("Comon pants"));
            equipment.getArmorSet().equip(armorRepository.findByName("Normal boots"));

        }
        return equipment;
    }

    public AbilityList getBasicAbilityList(String className, String element){
        AbilityList abilityList = new AbilityList();

        if (className.equals(ClassType.Mage.name())){
            abilityList.learnAbility(magickRepository.findByDescriptionAndElement("Basic spell", element));
        }

        if (className.equals(ClassType.Archer.name())){
            abilityList.learnAbility(skillsRepository.findByName("Fixed shoot"));
        }

        if (!className.equals(ClassType.Mage.name()) && !className.equals(ClassType.Archer.name())){
            abilityList.learnAbility(skillsRepository.findByName("Strong slash"));
        }

        return abilityList;
    }
}
