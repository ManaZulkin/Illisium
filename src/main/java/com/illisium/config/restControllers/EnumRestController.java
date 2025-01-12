package com.illisium.config.restControllers;

import com.illisium.basic.en.ArmorType;
import com.illisium.basic.en.Rare;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enum")
@CrossOrigin(origins = "http://localhost:8080")
public class EnumRestController {

    @GetMapping("/armor-types")
    public List<String> getArmorTypes() {
        return Arrays.stream(ArmorType.values()).map(Enum::name).collect(Collectors.toList());
    }

    @GetMapping("/rare-types")
    public List<String> getRareTypes(){
        return Arrays.stream(Rare.values()).map(Enum::name).collect(Collectors.toList());
    }
}
