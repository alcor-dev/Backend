package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller1 {

    //Usamos la anotación Autowired para conectar los datos del Person que vamos a hacer
    //Al hacer uso del autowired, conectamos todos los Autowired del mismo tipo
    @Autowired
    Person person;
    //Creamos la URL que se nos pide
    @GetMapping("/controller1/addPerson")
    //Creamos el método en el que recogemos los header requeridos: nombre, ciudad y edad
    public String addPerson(@RequestHeader("name") String name, @RequestHeader("city") String city, @RequestHeader("age") int age) {
        //Generamos un clase persona con los datos para hacer más sencilla la interacción
        person.setName(name);
        person.setCity(city);
        person.setAge(age);
        //Hacemos un return con el nuevo objeto generado
        return "La persona es: " + person.getName() + " de: " + person.getCity() + " y tiene " + person.getAge() + " años";
    }

}
