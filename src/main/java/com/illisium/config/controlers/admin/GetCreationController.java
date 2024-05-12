package com.illisium.config.controlers.admin;

import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monster;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/create")
public class GetCreationController {


    @GetMapping("")
    public String adminCreate(){

        return "/gm/create/creationPage";
    }


    @GetMapping("/createWeapon")
    public String createWeapon(@ModelAttribute(name = "weapon") Weapon weapon){
        return "/gm/create/createWeapon";
    }

    @GetMapping("/createArmor")
    public String createArmor(@ModelAttribute(name = "armor") Armor armor){
        return "/gm/create/createArmor";
    }

    @GetMapping("/createSpell")
    public String createSpell(@ModelAttribute(name = "spell") Magick magick){
        return "/gm/create/createSpell";
    }

    @GetMapping("/createSkill")
    public String createSkill(@ModelAttribute(name = "skill") Skills skills){
        return "/gm/create/createSkill";
    }

    @GetMapping("/createItem")
    public String createItem(@ModelAttribute(name = "item") Item item){
        return "/gm/create/createItem";
    }

    @GetMapping("/createMonster")
    public String monsterPreview(Model model){
        model.addAttribute("monster", new Monster());
        return "/gm/create/createMonster";
    }

    @GetMapping("/gm/session/createBattle")
    public String createBattle(Model model){
        return "/gm/session/createBattle";
    }

    @GetMapping("/gm/session/battle")
    public String battle(Model model){

        return "/gm/session/battle";
    }
}

