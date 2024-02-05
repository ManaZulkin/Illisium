package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.sesion.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/session")
public class AdminSessionController {
    AdminService adminService;



    @Autowired
    public AdminSessionController(AdminService adminService){
        this.adminService = adminService;
    }


    @GetMapping("/select")
    public String SessionSellect(Model model){
        model.addAttribute("sessionList", adminService.getAllSessionListForGameMaster());
        return "/gm/session/select";
    }

    @GetMapping("/newSession")
    public String createNewSession(Model model){
        Session session = new Session();
        model.addAttribute("newSession", session);
        return "/gm/session/newSession";
    }

    @PostMapping("/newSession")
    public String startNewSession(@ModelAttribute(name = "Session") Session session){
        session.setGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
        adminService.saveSession(session);
        return "redirect:/gm/session/sessionPage";
    }

    @GetMapping("/sessionPage")
    public String sessionPage(){
        return "/gm/session/sessionPage";
    }
}
