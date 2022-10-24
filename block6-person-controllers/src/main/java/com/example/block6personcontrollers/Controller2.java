package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
@Configurable
public class Controller2 {

    @Autowired
    Person person;

    @Autowired
    List<City> cityList;

    @PostMapping("/controller2/getPerson")
    public String getPersona() {
        return "La edad de " + person.getName() + " multiplicada por dos 2 es: " + (person.getAge() * 2);
    }

    @GetMapping("/controller2/getCity")
    public String getListCity() {

        return cityList.get(0).getName();
    }
}
