package com.illisium.config.controlers;

import com.illisium.config.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {
    private final AdminService adminService;

    @Autowired
    public HelloControler(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/startPage")
    public String letsStart(){
        return "startPage";
    }


}
