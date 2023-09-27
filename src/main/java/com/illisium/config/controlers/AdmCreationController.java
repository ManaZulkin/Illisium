package com.illisium.config.controlers;

import com.illisium.bin.IMPL.Armor;
import com.illisium.bin.INT.IArmor;
import com.illisium.bin.en.ArmorType;
import com.illisium.config.repositories.ChestArmorRepository;
import com.illisium.models.armor.DBArmor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gm")
public class AdmCreationController {

    private final ChestArmorRepository chestArmorRepository;

    @Autowired
    public AdmCreationController(ChestArmorRepository chestArmorRepository) {
        this.chestArmorRepository = chestArmorRepository;
    }

    @GetMapping("/create")
    public String adminCreate(){
        return "/gm/creationPage";
    }

    @GetMapping("/createMonster")
    public String createMonster(){
        return "/gm/createMonster";
    }

    @GetMapping("/gmStartPage")
    public String gmStartPage(){
        return "/gm/gmStartPage";
    }

    @GetMapping("/createWeapon")
    public String createWeapon(){
        return "/gm/createWeapon";
    }

    @GetMapping("/createArmor")
    public String createArmor(){
        return "/gm/createArmor";
    }

    @PostMapping("/createArmor")
    public String saveArmor(@ModelAttribute Armor armor){
        if (armor.getInfo().getType().equalsIgnoreCase(ArmorType.CHEST.name())){
            try{
                DBArmor DBArmor = convertToDatabaseStyle(armor);

            }catch (Exception e){
                return "redirect:/common/error";
            }
        }
        return "redirect:/common/success";
    }

    public DBArmor convertToDatabaseStyle(Armor armor){
            DBArmor DBArmor = new DBArmor();
            DBArmor.setAgility(armor.getStats().getAgility());
            DBArmor.setCharisma(armor.getStats().getCharisma());
            DBArmor.setDurability(armor.getStats().getDurability());
            DBArmor.setIntelligent(armor.getStats().getIntelligent());
            DBArmor.setLuck(armor.getStats().getLuck());
            DBArmor.setStamina(armor.getStats().getStamina());
            DBArmor.setStrange(armor.getStats().getStrange());
            DBArmor.setType(armor.getInfo().getType());
            DBArmor.setRare(armor.getInfo().getRare());
            DBArmor.setName(armor.getInfo().getName());
        return DBArmor;
    }

    public IArmor checkTypeOfArmor(DBArmor DBArmor){
        IArmor armor = null;
        return armor;
    }


}
