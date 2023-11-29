package com.illisium.config.controlers;

import com.illisium.config.services.AdminService;
import com.illisium.models.abylities.Magick;
import com.illisium.models.abylities.Skills;
import com.illisium.models.equpment.Armor;
import com.illisium.models.equpment.Weapon;
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

    @GetMapping("/createMonster")
    public String createMonster(){
        return "/gm/create/createMonster";
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
}
