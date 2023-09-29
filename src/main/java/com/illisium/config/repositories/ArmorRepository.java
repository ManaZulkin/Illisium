package com.illisium.config.repositories;

import com.illisium.models.equpment.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorRepository extends JpaRepository<Armor, Integer> {
    Optional<Armor> findByArmorNameAndArmorType(String armorName, String armorType);

}
