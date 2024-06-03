package com.illisium.config.controlers.player;

import com.illisium.config.services.PlayerService;
import com.illisium.config.util.CharacterUtil;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.creature.CreatureCreatorHelper;
import com.illisium.modelsDB.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/player")
public class PostCharacterController {

    private final PlayerService playerService;
    private final CharacterUtil characterUtil;
    private final CreatureCreatorHelper creatorHelper;

    @Autowired
    public PostCharacterController(PlayerService playerService, CharacterUtil characterUtil, CreatureCreatorHelper creatorHelper) {
        this.playerService = playerService;
        this.characterUtil = characterUtil;
        this.creatorHelper = creatorHelper;
    }

    @PostMapping("/newCharacter")
    public String saveCharacter(@ModelAttribute(name = "character") Character newChar){
        newChar.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        newChar.setEquipment(creatorHelper.getBasicEquipmentForCharacterByClass(newChar.getClasses().getClassName()));
        newChar.setAbilities(creatorHelper.getBasicAbilityList(
                newChar.getClasses().getClassName(), newChar.getInfoChar().getElement()
        ));

        playerService.saveCharacter(newChar);
        return "redirect:/player/characters";
    }



    @PostMapping("/characters")
    public String selectCharacter(@ModelAttribute(name = "character")Character character1){
        characterUtil.setCharacter(playerService.getCharacterByName(character1.getName()));

        return "redirect:/player/findSession";
    }



    @PostMapping("/findSession")
    public String findOpenSession(@ModelAttribute(name = "sesion") Session session1){
        characterUtil.setSession(playerService.getSessionByName(session1.getSessionName()));
        playerService.joinToOpenRoom(characterUtil.getSession(), characterUtil.getCharacter());
        return "redirect:/player/charsheet";
    }

}
