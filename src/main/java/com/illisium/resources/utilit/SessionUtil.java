package com.illisium.resources.utilit;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.config.sequrity.LoggedUser;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.OpenRoom;
import com.illisium.modelsDB.session.Session;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class SessionUtil {

    private final LoggedUser loggedUser;
    private final SessionRepository sessionRepository;
    private final OpenRoomRepository openRoomRepository;
    private final CharacterRepository characterRepository;


    public SessionUtil(LoggedUser loggedUser, SessionRepository sessionRepository, OpenRoomRepository openRoomRepository, CharacterRepository characterRepository) {
        this.loggedUser = loggedUser;
        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
        this.characterRepository = characterRepository;
    }

    public void changeSessionStatus(Session session) {
            if (sessionRepository.findAll().contains(session)){
                session.setActiveSession(true);
                sessionRepository.save(session);
                for (Session s: sessionRepository.findAllByGameMaster(session.getGameMaster())) {
                    if (!Objects.equals(s.getSessionName(), session.getSessionName())){
                        s.setActiveSession(false);
                        sessionRepository.save(s);
                    }
                }
            }

    }

    public void playersCheck(Session session) {
        List<OpenRoom> rooms = openRoomRepository.findAll();

        for (OpenRoom room: rooms) {
            if (session.getId().equals(room.getSession().getId())) {
                Character character = characterRepository.findByName(room.getCharacterName());
                if (!loggedUser.getAllActiveUsersNames().contains(character.getUserName())){
                    openRoomRepository.delete(room);
                }

            }

        }
    }


}
