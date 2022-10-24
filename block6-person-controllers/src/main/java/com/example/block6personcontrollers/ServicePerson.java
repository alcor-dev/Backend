package com.example.block6personcontrollers;

import org.springframework.stereotype.Service;


public interface ServicePerson {

    //Creación de los métodos a usar dentro de la interfaz
    public String showLast();
    public void addToList(String name, int population);
    public void showList();
    public String writeList();
}
