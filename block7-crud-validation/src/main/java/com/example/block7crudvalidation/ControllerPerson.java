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
            throw new UnprocessableEntityException();
        }
    }

    @GetMapping("/{id}")
    public Person readPersonById(@PathVariable("id") String id) throws EntityNotFoundException {
        return personService.readPersonById(id);
    }

    @GetMapping("/{name}")
    public Person readPersonByName(@PathVariable("name") String name) throws EntityNotFoundException{
        return personService.readPersonByName(name);
    }

    @GetMapping("/all")
    public List<Person> readAllPerson() {
        return personService.readEveryPerson();
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody Person person) throws Exception {
        if (person.checkData()){
            personService.updatePerson(person);
            return "La persona: " + person.getName() + " ha sido actualizada";
        } else {
            throw new UnprocessableEntityException();
        }
    }
}
