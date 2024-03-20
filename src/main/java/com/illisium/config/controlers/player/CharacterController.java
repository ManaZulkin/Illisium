package com.illisium.config.controlers.player;

import com.illisium.config.services.PlayerService;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class CharacterController {
    private final PlayerService playerService;

    private Session session;
    private Character character = new Character();

    @Autowired
    public CharacterController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/newCharacter")
    public String createCharacter(Model model){
        model.addAttribute("character", character);
        return "player/newCharacter";
    }

    @PostMapping("/newCharacter")
    public String saveCharacter(@ModelAttribute(name = "character")Character newChar){
        newChar.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        playerService.saveCharacter(newChar);
        return "redirect:/player/characters";
    }

    @GetMapping("/characters")
    public String charactersList(Model model){
        model.addAttribute("charactersList", playerService.getCharacterList());
        model.addAttribute("character", character);
        return "/player/charactersList";
    }

    @PostMapping("/characters")
    public String selectCharacter(@ModelAttribute(name = "character")Character character1){
        character = playerService.getCharacterByName(character1.getName());

        return "redirect:/player/findSession";
    }

    @GetMapping("/findSession")
    public String findSession(Model model){
        model.addAttribute("session", session);
        model.addAttribute("character", character);
        return "/player/findSession";
    }


}
