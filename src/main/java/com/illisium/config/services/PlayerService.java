package com.illisium.config.services;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    final CharacterRepository characterRepository;
    final SessionRepository sessionRepository;
    final OpenRoomRepository openRoomRepository;

    @Autowired
    public PlayerService(CharacterRepository characterRepository, SessionRepository sessionRepository, OpenRoomRepository openRoomRepository) {
        this.characterRepository = characterRepository;
        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
    }

    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    public List<Character> getCharacterList(){

        return characterRepository.findAll();
    }

    public List<Session> getOpenSession(){

        return sessionRepository.findAllByActiveSessionIsTrue();
    }

    public Session getSessionByName(String name){
        return sessionRepository.findBySessionName(name);
    }
    public Character getCharacterByName(String name){
        return characterRepository.findByName(name);
    }

    public void joinToOpenRoom(Session session){
        sessionRepository.save(session);
    }

}
