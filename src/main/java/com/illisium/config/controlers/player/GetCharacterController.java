package com.illisium.config.controlers.player;

import com.illisium.config.services.PlayerService;
import com.illisium.config.util.CharacterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/player")
public class GetCharacterController {

    private final PlayerService playerService;
    private final CharacterUtil characterUtil;

    @Autowired
    public GetCharacterController(PlayerService playerService, CharacterUtil characterUtil) {
        this.playerService = playerService;
        this.characterUtil = characterUtil;
    }

    @GetMapping("/newCharacter")
    public String createCharacter(Model model){
        model.addAttribute("character", characterUtil.getCharacter());
        return "player/newCharacter";
    }

    @GetMapping("/characters")
    public String charactersList(Model model){
        model.addAttribute("charactersList", playerService.getCharacterList());
        model.addAttribute("character", characterUtil.getCharacter());
        return "/player/charactersList";
    }

    @GetMapping("/findSession")
    public String findSession(Model model){
        model.addAttribute("sesion", characterUtil.getSession());
        model.addAttribute("character", characterUtil.getCharacter());
        model.addAttribute("openSessionList", playerService.getOpenSession());
        return "/player/findSession";
    }

    @GetMapping("/charsheet")
    public String charsheet(Model model){
        try {
            playerService.sessionStatusUpdate(characterUtil.getSession());
        }
        catch (Exception e){
            return "redirect:/player/findSession";
        }
        model.addAttribute("character", characterUtil.getCharacter());
        model.addAttribute("sesion", characterUtil.getSession());
        return "/player/charsheet";
    }
}
