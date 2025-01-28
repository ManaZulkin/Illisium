//package com.illisium.config.restControllers;
//
//
//import com.illisium.config.repositories.ArmorRepository;
//import com.illisium.config.repositories.ItemRepository;
//import com.illisium.modelsDB.equpment.Armor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/items")
//@CrossOrigin(origins = "http://localhost:8080")
//public class ItemsRestController {
//
//
//    private final ItemRepository itemRepository;
//    private final ArmorRepository armorRepository;
//
//    public ItemsRestController(ItemRepository itemRepository, ArmorRepository armorRepository) {
//        this.itemRepository = itemRepository;
//        this.armorRepository = armorRepository;
//    }
//
//
//    @GetMapping("/getArmorByName")
//    public Armor getItemByName(String name) {
//
//        return armorRepository.findByName(name);
//    }
//
//    @GetMapping("/newArmor")
//    public Armor getNewArmor() {
//        return new Armor();
//    }
//
//    @PostMapping("/saveArmor")
//    public Armor saveArmor(@RequestBody Armor armor) {
//        return armorRepository.save(armor);
//    }
//
//}
