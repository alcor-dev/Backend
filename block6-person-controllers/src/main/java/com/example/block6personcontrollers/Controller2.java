package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller2 {

    @Autowired
    Person person;

    @PostMapping("/controller2/getPerson")
    public String getPersona() {
        return "La edad de " + person.getName() + " multiplicada por dos 2 es: " + (person.getAge() * 2);
    }

}
