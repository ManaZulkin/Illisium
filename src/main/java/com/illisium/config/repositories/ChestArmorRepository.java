package com.illisium.config.repositories;

import com.illisium.models.armor.ChestArmor;
import com.illisium.models.armor.DBArmor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChestArmorRepository extends JpaRepository<ChestArmor, Integer> {
    Optional<ChestArmor> findByName(String name);

}
