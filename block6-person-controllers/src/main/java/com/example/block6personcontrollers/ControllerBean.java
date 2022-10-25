package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Configuration
public class ControllerBean {

    //Al usar el Autowired, llamamos a que busque dentro de otras clases otro objeto que coincida con el tipo
    //Al haber 3 Beans dentro del BeanConfigurator, no logra decidirse por ninguno y no muestra ninguna información
    //Usamos Qualifier como forma de filtro para hacer que el programa elija el Bean que más nos convenga
    @Autowired
    @Qualifier("bean2")
    PersonBean personBean;

    //Creamos una url donde a partir de cualquier entrada desde localhost:8080/controller/bean/ podamos usar
    //Lo que queramos
    @GetMapping("controller/bean/{bean}")
    public String getBean() {
        return personBean.getName();
    }
}
