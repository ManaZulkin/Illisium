package com.illisium.config.repositories;

import com.illisium.modelsDB.abylities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    Optional<Skills> findByNameAndClas(String skillName, String clas);
}
