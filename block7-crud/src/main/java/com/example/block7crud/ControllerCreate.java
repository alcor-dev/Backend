package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class ControllerCreate {

    @Autowired
    PersonServiceImpl personService;

    @PostMapping
    public String addPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return "La persona de nombre: " + person.getName().toUpperCase() + " ha sido añadida";
    }
}
