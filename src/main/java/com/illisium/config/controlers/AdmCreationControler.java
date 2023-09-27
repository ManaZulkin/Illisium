package com.illisium.config.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm")
public class AdmCreationControler {
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
    public
}
