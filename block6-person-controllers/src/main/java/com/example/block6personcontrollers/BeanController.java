package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BeanController {

    @Qualifier("beanDoesThings1")
    PersonBean personBean1 = new PersonBean("Antonio", "Málaga", 2000);
    PersonBean personBean2 = new PersonBean("Jaskier", "Cualquiera", 30);
    PersonBean personBean3 = new PersonBean("Geralt", "Rivia", 50);

    @GetMapping("/collector/bean/{bean}")
    public String getStuff(@PathVariable("bean") String path) {
        String names = "Names are";
        return names;
    }




}
