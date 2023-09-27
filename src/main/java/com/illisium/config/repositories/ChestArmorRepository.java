package com.illisium.config.repositories;

import com.illisium.models.armor.DBArmor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChestArmorRepository extends JpaRepository<DBArmor, Integer> {
    Optional<DBArmor> findByName(String name);

}
