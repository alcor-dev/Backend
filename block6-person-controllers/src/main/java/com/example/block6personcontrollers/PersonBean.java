package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PersonBean {

    private String name;
    private String city;
    private int age;

    PersonBean(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Bean
    @Qualifier("beanDoesThings1")
    public String beanDoesThings1(){
        return "Este es el Bean 1 " + getName();
    }

    @Bean
    @Qualifier("beanDoesThings2")
    public String beanDoesThings2(){
        return "Este es el Bean 2 y devuelve la ciudad: " + getCity();
    }

    @Bean
    @Qualifier("beanDoesThings3")
    public String beanDoesThings3(){
        return "Este es el bean 3 y devuelve la edad: " + getAge();
    }
}
