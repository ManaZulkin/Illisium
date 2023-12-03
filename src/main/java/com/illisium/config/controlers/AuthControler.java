package com.illisium.config.controlers;

import com.illisium.config.sequrity.RegistrationService;
import com.illisium.config.util.PersonValidator;
import com.illisium.config.sequrity.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthControler {
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthControler(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person, @ModelAttribute( name = "role") String role){
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String perfomRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "/auth/registrtion";
        registrationService.register(person);
        if (person.getRole().equalsIgnoreCase("ROLE_ADMIN") )  return "redirect:/auth/StartPageAdmin";
        else if (person.getRole().equalsIgnoreCase("ROLE_USER") )  return "redirect:/auth/StartPagePlayer";
        else return "redirect:/auth/login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/StartPageAdmin")
    public String startPageAdmin(){
        return "auth/StartPage";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/StartPagePlayer")
    public String startPagePlayer(){
        return "/player/playerStartPage";
    }
}
