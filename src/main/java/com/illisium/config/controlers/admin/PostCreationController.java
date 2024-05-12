package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monster;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/create")
public class PostCreationController {
    private final AdminService adminService;

    public PostCreationController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/createWeapon")
    public String saveWeapon(@ModelAttribute(name = "weapon") Weapon weapon){
        adminService.saveWeapon(weapon);
        return "redirect:/gm/create/createWeapon";
    }

    @PostMapping("/createArmor")
    public String saveArmor(@ModelAttribute(name = "armor") Armor armor){
        adminService.saveArmor(armor);
        return "redirect:/gm/create/createArmor";
    }

    @PostMapping("/createSpell")
    public String saveSpell(@ModelAttribute(name = "spell") Magick magick){
        adminService.saveMagick(magick);
        return "redirect:/gm/create/createSpell";
    }

    @PostMapping("/createSkill")
    public String saveSkill(@ModelAttribute(name = "Skill") Skills skills){
        adminService.saveSkill(skills);
        return "redirect:/gm/create/createSpell";
    }

    @PostMapping("/createItem")
    public String saveItem(@ModelAttribute(name = "item") Item item){
        adminService.saveItem(item);
        return "redirect:/gm/create/createItem";
    }

    @PostMapping("/createMonster")
    public String saveMonster(@ModelAttribute(name = "monster") Monster monster){
        adminService.saveMonster(monster);
        return "redirect:/gm/create/createMonster";
    }

    @PostMapping("/gm/session/createBattle")
    public String apruveBattle(Model model){

        return "redirect:/gm/session/battle";
    }

    @PostMapping("/gm/session/battle")
    public String finishBattle(Model model){

        return "redirect:/gm/session/sessionPage";
    }
}
