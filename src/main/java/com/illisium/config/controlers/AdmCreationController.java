package com.illisium.config.controlers;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monster;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/create")
public class AdmCreationController {
    private final AdminService adminService;


    @Autowired
    public AdmCreationController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public String adminCreate(){
        return "/gm/create/creationPage";
    }

    @GetMapping("/createMonster1")
    public String createMonster(@ModelAttribute(name = "monster")Monster monster){
        return "/gm/create/createMonster1";
    }

    @PostMapping("/createMonster1")
    public String createMonsterToStep2(@ModelAttribute(name = "monster")Monster monster){
        return "redirect:/gm/create/createMonster2";
    }

    @GetMapping("/createMonster2")
    public String createMonsterSteap2(@ModelAttribute(name = "monster")Monster monster){
        return "/gm/create/createMonster2";
    }

    @PostMapping("/createMonster2")
    public String CreateMonsterPreview(@ModelAttribute(name = "monster")Monster monster){

        return "redirect:/gm/create/previewMonster";
    }
    @GetMapping("/createWeapon")
    public String createWeapon(@ModelAttribute(name = "weapon")Weapon weapon){
        return "/gm/create/createWeapon";
    }

    @PostMapping("/createWeapon")
    public String saveWeapon(@ModelAttribute(name = "weapon")Weapon weapon){
        adminService.saveWeapon(weapon);
        return "redirect:/gm/create/createWeapon";
    }

    @GetMapping("/createArmor")
    public String createArmor(@ModelAttribute(name = "armor")Armor armor){
        return "/gm/create/createArmor";
    }

    @PostMapping("/createArmor")
    public String saveArmor(@ModelAttribute(name = "armor") Armor armor){
        adminService.saveArmor(armor);
        return "redirect:/gm/create/createArmor";
    }

    @GetMapping("/createSpell")
    public String createSpell(@ModelAttribute(name = "spell")Magick magick){
        return "/gm/create/createSpell";
    }

    @PostMapping("/createSpell")
    public String saveSpell(@ModelAttribute(name = "spell")Magick magick){
        adminService.saveMagick(magick);
        return "redirect:/gm/create/createSpell";
    }
    @GetMapping("/createSkill")
    public String createSkill(@ModelAttribute(name = "skill")Skills skills){
        return "/gm/create/createSkill";
    }

    @PostMapping("/createSkill")
    public String saveSkill(@ModelAttribute(name = "Skill")Skills skills){
        adminService.saveSkill(skills);
        return "redirect:/gm/create/createSpell";
    }

    @GetMapping("/createItem")
    public String createItem(@ModelAttribute(name = "item")Item item){

        return "/gm/create/createItem";
    }

    @PostMapping("/createItem")
    public String saveItem(@ModelAttribute(name = "item")Item item){
        adminService.saveItem(item);
        return "redirect:/gm/create/createItem";
    }

    @GetMapping("/previewMonster")
    public String monsterPreview(){
        return "/gm/create/previewMonster";
    }
    @PostMapping("/previewMonster")
    public String Monster(){
        return "redirect:/gm/createMonster1";
    }
}
