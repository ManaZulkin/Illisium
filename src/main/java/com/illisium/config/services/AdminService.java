package com.illisium.config.services;

import com.illisium.config.repositories.ArmorRepository;
import com.illisium.config.repositories.WeaponRepository;
import com.illisium.models.equpment.Armor;
import com.illisium.models.equpment.Weapon;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final ArmorRepository armorRepository;
    private final WeaponRepository weaponRepository;

    public AdminService(ArmorRepository armorRepository, WeaponRepository weaponRepository) {
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_SOME_OTHER')")
    public void doAdminStuff(){
        System.out.println("Admin stuff");
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
}
