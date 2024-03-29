package com.illisium.config.repositories;

import com.illisium.modelsDB.creature.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    Character findByName(String name);

    List<Character> findAllByUserName(String userName);
}
