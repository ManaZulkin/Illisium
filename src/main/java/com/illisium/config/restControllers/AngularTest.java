package com.illisium.config.restControllers;

import com.illisium.config.sequrity.entety.Person;
import com.illisium.config.sequrity.reposetory.PeopleRepository;
import com.illisium.modelsDB.equpment.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AngularTest {

    private final PeopleRepository peopleRepository;


    public AngularTest(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/helloAngular")
    public Item helloAngular() {
        return new Item() ;
    }

    @GetMapping("/personForAngular")
    public Optional<Person> personForAngular() {
        return peopleRepository.findById(1) ;
    }
}
