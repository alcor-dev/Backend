package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/person")
public class ControllerRead {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/{id}")
    public String readPersonById(@PathVariable("id") String id) throws FileNotFoundException {
        Person person = personService.readPersonById(id);
        return "Nombre: " + person.getName() + " Edad: " + person.getAge() + " Ciudad: " + person.getCity();
    }

    @GetMapping("/name/{name}")
    public String readPersonByName(@PathVariable("name") String name) throws FileNotFoundException {
        Person person = personService.readPersonByName(name);
        return "Nombre: " + person.getName() + " Edad: " + person.getAge() + " Ciudad: " + person.getCity();
    }
}
