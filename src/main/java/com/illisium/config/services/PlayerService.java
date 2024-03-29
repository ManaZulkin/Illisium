package com.illisium.config.services;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.OpenRoom;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    final CharacterRepository characterRepository;
    final SessionRepository sessionRepository;
    final OpenRoomRepository openRoomRepository;
    final GlobalService globalService;


    @Autowired
    public PlayerService(CharacterRepository characterRepository, SessionRepository sessionRepository, OpenRoomRepository openRoomRepository, GlobalService globalService) {
        this.characterRepository = characterRepository;
        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
        this.globalService = globalService;
    }

    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    public List<Character> getCharacterList(){


        return characterRepository.findAllByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public List<Session> getOpenSession(){
        List<Session> activeSessions = sessionRepository.findAllByActiveSessionIsTrue();
//        for (Session s :
//                activeSessions) {
//            if (!globalService.loggedIn().contains(s.getGameMaster())){
//                activeSessions.remove(s);
//            }
//        }
        return activeSessions;
    }

    public Session getSessionByName(String name){
        return sessionRepository.findBySessionName(name);
    }
    public Character getCharacterByName(String name){
        return characterRepository.findByName(name);
    }


    public void sessionStatusUpdate(Session session) throws RuntimeException {
        if(!sessionRepository.findBySessionName(session.getSessionName()).isActiveSession())
            throw new RuntimeException("Session is closed or not exist");
    }
    public void joinToOpenRoom(Session session, Character character){
       openRoomRepository.save(new OpenRoom(session, character.getName()));
    }

}
