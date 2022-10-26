package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/person")
public class ControllerDelete {

    //Inyectamos el servicio con Autowired
    @Autowired
    PersonServiceImpl personService;

    //Lanzamos una petición a nuestro servidor usando como identificador el ID para borrar una entrada
    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") String id) throws FileNotFoundException {
        String name = personService.readPersonById(id).getName();
        personService.deletePerson(id);
        return "La persona de nombre: " + name + " ha sido eliminada";
    }
}
