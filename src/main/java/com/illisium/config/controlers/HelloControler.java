package com.illisium.config.controlers;

import com.illisium.config.repositories.CharacterRepository;
import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.config.sequrity.entety.Person;
import com.illisium.config.sequrity.service.RegistrationService;
import com.illisium.config.services.AdminService;
import com.illisium.config.util.AdminSession;
import com.illisium.config.util.PersonValidator;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.creature.Monsters;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import com.illisium.modelsDB.session.Battle;
import com.illisium.modelsDB.session.OpenRoom;
import com.illisium.modelsDB.session.Session;
import com.illisium.resources.utilit.SessionUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HelloControler {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    private final SessionRepository sessionRepository;
    private final OpenRoomRepository openRoomRepository;
    private final CharacterRepository characterRepository;
    private final AdminService adminService;
    private final AdminSession adminSession;
    private final SessionUtil sessionUtil;

    @Autowired
    public HelloControler(RegistrationService registrationService, PersonValidator personValidator, SessionRepository sessionRepository, OpenRoomRepository openRoomRepository, CharacterRepository characterRepository, AdminService adminService, AdminSession adminSession, SessionUtil sessionUtil) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;

        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
        this.characterRepository = characterRepository;
        this.adminService = adminService;
        this.adminSession = adminSession;
        this.sessionUtil = sessionUtil;
    }


    @GetMapping("/HelloPage")
    public String HelloPage(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("role", "");
        return "/HelloPage";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/gm/startPage")
    public String startPageAdmin(Model model){
        model.addAttribute("sesion", adminSession.getSession());
        if (adminSession.getSession() == null){
            model.addAttribute("newSession", new Session());
        } else {
            model.addAttribute("newSession", adminSession.getSession());
        }

        model.addAttribute("sessionList", adminService.getAllSessionListForGameMaster());
        if (adminSession.getSession() == null){
            model.addAttribute("sesion", new Session());
        } else {
            model.addAttribute("newSession", adminSession.getSession());
        }

        model.addAttribute("battle", new Battle());
        model.addAttribute("monsters", new Monsters());
        model.addAttribute("weapon", new Weapon());
        model.addAttribute("armor", new Armor());
        model.addAttribute("item", new Item());
        model.addAttribute("spell", new Magick());
        model.addAttribute("skill", new Skills());


        return "gm/startPage";
    }
//    @PreAuthorize("hasRole('ROLE_USER')")
//    @GetMapping("/player/startPage")
//    public String startPagePlayer(){
//        return "player/startPage";
//    }

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
            System.out.println("--------------------No session found------------------------");
            List<Character> characters = characterRepository.findAllByUserName(
                    SecurityContextHolder.getContext().getAuthentication().getName()
            );
            System.out.println("-------------------Characters found-----------------" + characters);
            for(Character character : characters){
                if(openRoomRepository.findByCharacterName(character.getName()) != null) {
                    List<OpenRoom> openRoom = openRoomRepository.findByCharacterName(character.getName());
                    openRoomRepository.deleteAll(openRoom);
                }
            }
        }
        System.out.println("--------------Logged out----------------");

        return "redirect:/HelloPage";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "/HelloPage";
        registrationService.register(person);
        return "redirect:/HelloPage";
    }
}
