package com.illisium.config.repositories;

import com.illisium.modelsDB.equpment.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer> {
    Optional<Armor> findByNameAndType(String armorName, String armorType);

    Armor findByName(String name);
}
