package com.example.block7crudvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ControllerPerson {

    @Autowired
    PersonServiceImpl personService;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) throws Exception {
        if(person.checkData()) {
            personService.createPerson(person);
            return "Añadida persona: " + person.getName().toUpperCase();
        } else {
            return "El objeto persona estaba incompleto";
        }

    }

    @GetMapping("/{id}")
    public Person readPersonById(@PathVariable("id") String id) throws FileNotFoundException {
        return personService.readPersonById(id);
    }

    @GetMapping("/{name}")
    public Person readPersonByName(@PathVariable("name") String name) throws Exception{
        return personService.readPersonByName(name);
    }

    @GetMapping("/all")
    public List<Person> readAllPerson() {
        return personService.readEveryPerson();
    }
}
