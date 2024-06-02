package com.illisium.config.util;

import com.illisium.config.repositories.*;
import org.springframework.stereotype.Component;

@Component
public class CreationRepositoryHolder {
    private final QuestRepository questRepository;
    private final ItemRepository itemRepository;
    private final ArmorRepository armorRepository;
    private final WeaponRepository weaponRepository;
    private final SkillsRepository skillsRepository;
    private final MagickRepository magickRepository;
    private final MonsterRepository monsterRepository;

    public CreationRepositoryHolder(QuestRepository questRepository, ItemRepository itemRepository, ArmorRepository armorRepository, WeaponRepository weaponRepository, SkillsRepository skillsRepository, MagickRepository magickRepository, MonsterRepository monsterRepository) {
        this.questRepository = questRepository;
        this.itemRepository = itemRepository;
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
        this.skillsRepository = skillsRepository;
        this.magickRepository = magickRepository;
        this.monsterRepository = monsterRepository;
    }

    public QuestRepository getQuestRepository() {
        return questRepository;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public ArmorRepository getArmorRepository() {
        return armorRepository;
    }

    public WeaponRepository getWeaponRepository() {
        return weaponRepository;
    }

    public SkillsRepository getSkillsRepository() {
        return skillsRepository;
    }

    public MagickRepository getMagickRepository() {
        return magickRepository;
    }

    public MonsterRepository getMonsterRepository() {
        return monsterRepository;
    }
}
