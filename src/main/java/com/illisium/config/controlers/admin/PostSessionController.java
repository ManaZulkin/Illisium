package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.config.util.AdminSession;
import com.illisium.modelsDB.others.Quest;
import com.illisium.modelsDB.session.Session;
import com.illisium.resources.utilit.SessionUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/session/")
public class PostSessionController {

    private final AdminSession adminSession;
    private final AdminService adminService;
    private final SessionUtil sessionUtil;


    public PostSessionController( AdminSession adminSession, AdminService adminService, SessionUtil sessionUtil) {
        this.adminSession = adminSession;
        this.adminService = adminService;
        this.sessionUtil = sessionUtil;
    }

    @PostMapping("/newSession")
    public String startNewSession(@ModelAttribute("Session")Session session){
        session.setGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
        adminSession.setSession(session);
        adminService.saveSession(adminSession.getSession());
        sessionUtil.changeSessionStatus(adminSession.getSession());
        return "redirect:/gm/startPage";
    }

    @PostMapping("/select")
    public String loadSession(@ModelAttribute("sessionList")Session session1){
        adminSession.setSession(adminService.getSessionBySessionName(session1.getSessionName()));
        adminSession.getSession().setActiveSession(true);
        sessionUtil.changeSessionStatus(adminSession.getSession());
        return "redirect:/gm/startPage";
    }

    @PostMapping("/createQuest")
    public String saveQuest(@ModelAttribute(name = "quest") Quest quest){
        quest.setSessionName(adminSession.getSession().getSessionName());
        adminService.saveQuest(quest);
        return "redirect:/gm/session/sessionPage";
    }
}
