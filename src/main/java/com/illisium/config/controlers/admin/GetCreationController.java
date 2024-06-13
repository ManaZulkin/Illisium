package com.illisium.config.controlers.admin;

import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monsters;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import com.illisium.modelsDB.session.Battle;
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
        return "redirect:/gm/startPage";
    }

    @GetMapping("/createArmor")
    public String createArmor(@ModelAttribute(name = "armor") Armor armor){
        return "redirect:/gm/startPage";
    }

    @GetMapping("/createSpell")
    public String createSpell(@ModelAttribute(name = "spell") Magick magick){
        return "redirect:/gm/startPage";
    }

    @GetMapping("/createSkill")
    public String createSkill(@ModelAttribute(name = "skill") Skills skills){
        return "redirect:/gm/startPage";
    }

    @GetMapping("/createItem")
    public String createItem(@ModelAttribute(name = "item") Item item){
        return "redirect:/gm/startPage";
    }

    @GetMapping("/createMonster")
    public String monsterPreview(Model model){
        model.addAttribute("monster", new Monsters());
        return "redirect:/gm/startPage";
    }

    @GetMapping("/gm/session/createBattle")
    public String createBattle(Model model){

        return "redirect:/gm/startPage";
    }

    @GetMapping("/gm/session/battle")
    public String battle(Model model){
        model.addAttribute("battle", new Battle());
        return "redirect:/gm/startPage";
    }
}

