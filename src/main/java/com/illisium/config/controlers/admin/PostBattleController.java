package com.illisium.config.controlers.admin;

import com.illisium.config.util.AdminSession;
import com.illisium.modelsDB.session.Battle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostBattleController {

    private final AdminSession adminSession;

    public PostBattleController(AdminSession adminSession) {
        this.adminSession = adminSession;
    }

    @PostMapping("/battle/addAllies")
    public String addAllies(@ModelAttribute(name = "battle") Battle battle){

        return "redirect:/gm/startPage";
    }

    @PostMapping("/battle/addEnemies")
    public String addEnemies(@ModelAttribute(name = "battle") Battle battle){

        return "redirect:/gm/startPage";
    }
}
