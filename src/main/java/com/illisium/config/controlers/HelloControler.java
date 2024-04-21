package com.illisium.config.controlers;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloControler {

    private final SessionRepository sessionRepository;
    private final OpenRoomRepository openRoomRepository;
    private final CharacterRepository characterRepository;

    @Autowired
    public HelloControler(SessionRepository sessionRepository, OpenRoomRepository openRoomRepository, CharacterRepository characterRepository) {

        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
        this.characterRepository = characterRepository;
    }


    @GetMapping("/HelloPage")
    public String HelloPage() {
        return "/HelloPage";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/gm/startPage")
    public String startPageAdmin(){
        return "gm/startPage";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/player/startPage")
    public String startPagePlayer(){
        return "player/startPage";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        System.out.println("--------------------Logging out--------------");
        Session session =
                sessionRepository.findByGameMasterAndActiveSession(
                        SecurityContextHolder.getContext().getAuthentication().getName(), true);
        if(session != null){
            session.setActiveSession(false);
            sessionRepository.save(session);
            openRoomRepository.deleteAll(openRoomRepository.findAllBySession(session));
        }
        else {
            List<Character> characters = characterRepository.findAllByUserName(
                    SecurityContextHolder.getContext().getAuthentication().getName()
            );
            for(Character character : characters){
                openRoomRepository.delete(
                        openRoomRepository.findByCharacterName(character.getName()));
            }
        }
        System.out.println("--------------Logged out----------------");

        return "redirect:/auth/login";
    }
}
