package com.illisium.config.controlers.admin;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.sesion.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/gm/session")
public class AdminSessionController {
    AdminService adminService;

    @Autowired
    public AdminSessionController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/select")
    public String SessionSellect(@ModelAttribute(name = "sessionList") ArrayList<Session> sessionList){
        sessionList = adminService.getAllSessionList();
        return "/gm/session/select";
    }

    @GetMapping("/newSesion")
    public String createNewSession(@ModelAttribute(name = "session") Session session){

        return "/gm/session/newSession";
    }
}
