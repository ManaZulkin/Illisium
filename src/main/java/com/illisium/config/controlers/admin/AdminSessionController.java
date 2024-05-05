package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.session.Battle;
import com.illisium.modelsDB.session.Session;
import com.illisium.resources.utilit.SessionUtil;
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
    private final AdminService adminService;
    private Session session;
    private final SessionUtil sessionUtil;
    private Battle battle;

    @Autowired
    public AdminSessionController(AdminService adminService, Session session, SessionUtil sessionUtil){
        this.adminService = adminService;
        this.session = session;
        this.sessionUtil = sessionUtil;
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
        sessionUtil.changeSessionStatus(this.session);
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
        sessionUtil.changeSessionStatus(session);
        return "redirect:/gm/session/sessionPage";
    }

    @GetMapping("/sessionPage")
    public String sessionPage(Model model){
        sessionUtil.playersCheck(session);
        model.addAttribute("sesion", session);
        model.addAttribute("openRoomSet", adminService.getOpenRoomSet(session));


        return "/gm/session/sessionPage";
    }
}
