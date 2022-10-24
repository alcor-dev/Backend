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
    @GetMapping("/user/{user}")
    //Pedimos en que la variable user almacene el nombre añadido en el path
    public String user(@PathVariable("user") String name){
        //Retornamos el nombre almacenado para usarlo
        return "Hola, el nombre del usuario es: " + name;
    }

    //Creamos un método con anotación PostMapping
    //Pedimos un body que se ajuste a los datos creando una clase exclusiva para tratar los datos
    //La clase hace mucho más sencilla la petición de datos
    @PostMapping("/useradd")
    //Aquí pedimos que se añada esa información a un usuario
    public String userAdd(@RequestBody User user){
        //Hacemos un return aprovechando los métodos de la clase usuario
        return "La edad del usuario " + user.getName() + " es: " + (user.getAge() + 1);
    }
}
