package com.illisium.config.controlers;

import com.illisium.bin.IMPL.Armor;
import com.illisium.bin.en.ArmorType;
import com.illisium.config.repositories.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm")
public class AdmCreationController {

    private final ArmorRepository ArmorRepository;

    @Autowired
    public AdmCreationController(ArmorRepository ArmorRepository) {
        this.ArmorRepository = ArmorRepository;
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
    public String createArmor(){
        return "/gm/createArmor";
    }

    @PostMapping("/createArmor")
    public String saveArmor(@ModelAttribute Armor armor){
        if (armor.getInfo().getType().equalsIgnoreCase(ArmorType.CHEST.name())){
            try{
                System.out.println("!!!");

            }catch (Exception e){
                return "redirect:/common/error";
            }
        }
        return "redirect:/common/success";
    }





}
