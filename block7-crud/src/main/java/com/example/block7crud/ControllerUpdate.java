package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class ControllerUpdate {

    //Inyección de dependencia de PersonServiceImpl
    @Autowired
    PersonServiceImpl personService;

    //Petición de actualización de persona
    @PutMapping("/{id}")
    public String personUpdate(@RequestBody Person person, @PathVariable("id") String id) {
        //Aceptamos el body que nos envien, pero una vez recogido le setteamos la ID introducida por URL
        person.setId(id);
        personService.updatePerson(person);
        return "Actualizado: " + person.getName();
    }
}
