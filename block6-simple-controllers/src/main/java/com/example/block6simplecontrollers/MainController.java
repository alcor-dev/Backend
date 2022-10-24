package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

//Creamos la clase con Rest controller y Request mapping
@RestController
//No le ponemos la ruta aquí puesto que solo pondríamos ("/") y es código más limpio si no ponemos nada
@RequestMapping
public class MainController {

    //Creamos un método con anotación GetMapping
    //Usamos el {} para crear una variable en la URL
    //Llamamos a la variable usando PathVariable
    @GetMapping("/user/{user}" )
    public String user(@PathVariable("user") String name){
        return "Hola, el nombre del usuario es: " + name;
    }

    //Creamos un método con anotación PostMapping
    @PostMapping("/useradd")
    public String userAdd(@RequestBody User user){
        return "La edad del usuario " + user.getName() + " es: " + (user.getAge() + 1);
    }
}
