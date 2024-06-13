package com.illisium.config.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionLogger {
    @GetMapping("/log")
    public List<String> log(String message) {
        List<String> logs = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(formatter);
        if (message == null){
            logs.add("[" + time + "] ");
        }else {
            logs.add("[" + time + "] " + message);
        }
        return logs;
    }
}
