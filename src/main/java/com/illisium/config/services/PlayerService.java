package com.illisium.config.services;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.modelsDB.creature.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    final
    CharacterRepository characterRepository;

    @Autowired
    public PlayerService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    public List<Character> getCharacterList(){

        return characterRepository.findAll();
    }

    public Character getCharacterByName(String name){
        return characterRepository.findByName(name);
    }
}
