package com.illisium.config.controlers.player;

import com.illisium.config.services.PlayerService;
import com.illisium.config.util.CharacterUtil;
import com.illisium.resources.mechaniks.Roll;
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
    private Integer dice;
    private final Roll roll = new Roll();

    @Autowired
    public GetCharacterController(PlayerService playerService, CharacterUtil characterUtil) {
        this.playerService = playerService;
        this.characterUtil = characterUtil;
    }

    @GetMapping("/startPage")
    public String startPage(Model model) {
        model.addAttribute("sesion", characterUtil.getSession());
        model.addAttribute("character", characterUtil.getCharacter());
        model.addAttribute("openSessionList", playerService.getOpenSession());
        model.addAttribute("charactersList", playerService.getCharacterList());
        model.addAttribute("rollDice", dice);
        model.addAttribute("roll", roll);
        return "player/startPage";
    }
}
