package com.illisium.config.repositories;

import com.illisium.modelsDB.creature.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

}
