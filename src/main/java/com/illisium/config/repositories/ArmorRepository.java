package com.illisium.config.repositories;

import com.illisium.models.equpment.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer> {
    Optional<Armor> findByArmorNameAndArmorType(String armorName, String armorType);

}
