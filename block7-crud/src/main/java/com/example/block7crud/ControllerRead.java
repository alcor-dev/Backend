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

    //Hacemos inyección de dependencias con el Autowired
    @Autowired
    PersonServiceImpl personService;

    //Crearemos la URL que usaremos para recuperar una persona por ID
    @GetMapping("/{id}")
    public String readPersonById(@PathVariable("id") String id) throws FileNotFoundException {
        Person person = personService.readPersonById(id);
        return "Nombre: " + person.getName() + " Edad: " + person.getAge() + " Ciudad: " + person.getCity();
    }

    //Creamos la URL que usaremos para recuperar una persona por nombre
    @GetMapping("/name/{name}")
    public String readPersonByName(@PathVariable("name") String name) throws Exception {
        Person person = personService.readPersonByName(name);
        return "Nombre: " + person.getName() + " Edad: " + person.getAge() + " Ciudad: " + person.getCity();
    }
}
