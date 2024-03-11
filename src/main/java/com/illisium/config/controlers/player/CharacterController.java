package com.illisium.config.controlers.player;

import com.illisium.config.services.PlayerService;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class CharacterController {
    private final PlayerService playerService;

    private Session session;
    private final Character character = new Character();

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
    public String saveCharacter(Model model){

        return "redirect:/player/characters";
    }

    @GetMapping("/characters")
    public String charactersList(){

        return "/player/charactersList";
    }

    @GetMapping("/findSession")
    public String findSession(Model model){
        model.addAttribute("session", session);
        return "/player/findSession";
    }


}
