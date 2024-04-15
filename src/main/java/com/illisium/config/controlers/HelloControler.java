package com.illisium.config.controlers;

import com.illisium.config.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {
    private final AdminService adminService;

    @Autowired
    public HelloControler(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/HelloPage")
    public String HelloPage() {
        return "/HelloPage";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/gm/startPage")
    public String startPageAdmin(){
        return "gm/startPage";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/player/startPage")
    public String startPagePlayer(){
        return "player/startPage";
    }


}
