package com.illisium.config.repositories;

import com.illisium.modelsDB.abylities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    ArrayList<Skills> findByNameAndClas(String skillName, String clas);
}
