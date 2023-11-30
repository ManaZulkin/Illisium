package com.illisium.config.services;

import com.illisium.config.repositories.*;
import com.illisium.models.abylities.Magick;
import com.illisium.models.abylities.Skills;
import com.illisium.models.equpment.Armor;
import com.illisium.models.equpment.Item;
import com.illisium.models.equpment.Weapon;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final ItemRepository itemRepository;
    private final ArmorRepository armorRepository;
    private final WeaponRepository weaponRepository;
    private final SkillsRepository skillsRepository;
    private final MagickRepository magickRepository;

    public AdminService(ItemRepository itemRepository, ArmorRepository armorRepository, WeaponRepository weaponRepository, SkillsRepository skillsRepository, MagickRepository magickRepository) {
        this.itemRepository = itemRepository;
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
        this.skillsRepository = skillsRepository;
        this.magickRepository = magickRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveWeapon(Weapon weapon){
        weaponRepository.save(weapon);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveArmor(Armor armor){
        armorRepository.save(armor);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveMagick(Magick magick){
        magickRepository.save(magick);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveSkill(Skills skills){
        skillsRepository.save(skills);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

}
