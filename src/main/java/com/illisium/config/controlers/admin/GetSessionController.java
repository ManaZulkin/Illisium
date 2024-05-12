package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.config.util.AdminSession;
import com.illisium.modelsDB.session.Session;
import com.illisium.resources.utilit.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm/session/")
public class GetSessionController {

    private final AdminService adminService;
    private final SessionUtil sessionUtil;
    private final AdminSession adminSession;


    public GetSessionController(AdminService adminService, SessionUtil sessionUtil, AdminSession adminSession) {
        this.adminService = adminService;
        this.sessionUtil = sessionUtil;
        this.adminSession = adminSession;
    }


    @GetMapping("/newSession")
    public String createNewSession(Model model){
        model.addAttribute("newSession", new Session());
        return "/gm/session/newSession";
    }

    @GetMapping("/select")
    public String SessionSelect(Model model){
        model.addAttribute("sessionList", adminService.getAllSessionListForGameMaster());
        model.addAttribute("sesion", new Session());
        return "/gm/session/select";
    }

    @GetMapping("/sessionPage")
    public String sessionPage(Model model){

        sessionUtil.playersCheck(adminSession.getSession());
        model.addAttribute("sesion", adminSession.getSession());
        model.addAttribute("openRoomSet", adminService.getOpenRoomSet(adminSession.getSession()));


        return "/gm/session/sessionPage";
    }
}
