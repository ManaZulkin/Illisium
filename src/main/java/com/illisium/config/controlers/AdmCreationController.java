package com.illisium.config.controlers;

import com.illisium.basic.en.ArmorType;
import com.illisium.basic.en.Rare;
import com.illisium.config.repositories.ArmorRepository;
import com.illisium.config.services.AdminService;
import com.illisium.models.equpment.Armor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm")
public class AdmCreationController {
    private final AdminService adminService;

    private final ArmorRepository armorRepository;

    @Autowired
    public AdmCreationController(AdminService adminService, ArmorRepository ArmorRepository) {
        this.adminService = adminService;
        this.armorRepository = ArmorRepository;
    }

    @GetMapping("/create")
    public String adminCreate(){
        return "/gm/creationPage";
    }

    @GetMapping("/createMonster")
    public String createMonster(){
        return "/gm/createMonster";
    }

    @GetMapping("/gmStartPage")
    public String gmStartPage(){
        return "/gm/gmStartPage";
    }

    @GetMapping("/createWeapon")
    public String createWeapon(){
        return "/gm/createWeapon";
    }

    @GetMapping("/createArmor")
    public String createArmor(@ModelAttribute(name = "armor")Armor armor){
        return "/gm/createArmor";
    }

    @PostMapping("/createArmor")
    public String saveArmor(@ModelAttribute(name = "armor") Armor armor){
        adminService.saveArmor(armor);
        return "redirect:/gm/createArmor";
    }





}
