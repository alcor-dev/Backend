package com.example.block6pathvariableheaders;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
    private final List<String> activeID = new ArrayList<String>(){{add("8"); add("9"); add("10");}};

    //Hacemos una petición para que podamos coger la información de acuerdo a unos patrones
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    //Hacemos una petición de un Body (en este caso un JSON) para que introduzca los datos
    //Ejercicio 1 del bloque
    @PostMapping("/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    //Ejercicio 2 del bloque
    @GetMapping("/user/{id}")
    public String getId(@PathVariable("id") String id) {
        return "La ID introducida es: " + id;
    }

    //Hacemos una petición para que usando unos parámetros concretos podamos actualizar una lista
    //Ejercicio 3 del bloque
    @PutMapping("/post")
    public String updateList(@RequestParam("var1") String var1, @RequestParam("var2") String var2) {
        activeID.add(var1);
        activeID.add(var2);

        return activeID.toString();
    }
}