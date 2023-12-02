package com.illisium.config.repositories;

import com.illisium.modelsDB.equpment.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

    Optional<Weapon> findByWeaponNameAndWeaponType(String weaponName, String weaponType);
    @Override
    Optional<Weapon> findById(Integer integer);
}
