package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@Configurable
public class Controller1 {

    //Usamos la anotación Autowired para conectar los datos del Person que vamos a hacer
    //Al hacer uso del autowired, conectamos todos los Autowired del mismo tipo
    @Autowired
    Person person;

    @Autowired
    ServicePersonImpl servicePerson;

    //Primer ejercicio realizado
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

    //Segundo ejercicio realizado
    @PostMapping("/controller1/addCity")
    public String addCity(@RequestHeader("name") String name, @RequestHeader("population") int population) {
        servicePerson.addToList(name, population);
        return servicePerson.showLast();
    }
}
