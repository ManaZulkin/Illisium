package com.illisium.config.controlers;

import com.illisium.resources.mechaniks.Roll;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roll")
public class RollController {

    @PostMapping("/d4")
    public String d4(@RequestParam int roll) {
        roll = Roll.d4();
    return String.valueOf(roll);
    }
    @PostMapping("/d6")
    public String d6(@RequestParam int roll) {
        roll = Roll.d6();
        return String.valueOf(roll);
    }
    @PostMapping("/d8")
    public String d8(@RequestParam int roll) {
        roll = Roll.d8();
        return String.valueOf(roll);
    }
    @PostMapping("/d10")
    public String d10(@RequestParam int roll) {
        roll = Roll.d10();
        return String.valueOf(roll);
    }
    @PostMapping("/d20")
    public String d20(@RequestParam int roll) {
        roll = Roll.d20();
        return String.valueOf(roll);
    }
}
