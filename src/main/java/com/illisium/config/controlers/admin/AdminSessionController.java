package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.session.Session;
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
    private Session session;


    @Autowired
    public AdminSessionController(AdminService adminService, Session session){
        this.adminService = adminService;
        this.session = session;
    }


    @GetMapping("/newSession")
    public String createNewSession(Model model){
        model.addAttribute("newSession", session);
        session.setGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
        return "/gm/session/newSession";
    }

    @PostMapping("/newSession")
    public String startNewSession(@ModelAttribute("Session")Session session){
        session.setGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
        this.session = session;
        adminService.saveSession(this.session);
        session.setActiveSession(true);
        return "redirect:/gm/session/sessionPage";
    }

    @GetMapping("/select")
    public String SessionSelect(Model model){
        model.addAttribute("sessionList", adminService.getAllSessionListForGameMaster());
        model.addAttribute("sesion", session);
        return "/gm/session/select";
    }

    @PostMapping("/select")
    public String loadSession(@ModelAttribute("sessionList")Session session1){
        this.session = adminService.getSessionBySessionName(session1.getSessionName());
        session.setActiveSession(true);
        System.out.println(session);
        return "redirect:/gm/session/sessionPage";
    }

    @GetMapping("/sessionPage")
    public String sessionPage(Model model){
        model.addAttribute("sesion", session);


        return "/gm/session/sessionPage";
    }
}