package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePersonImpl implements ServicePerson {

    @Autowired
    List<City> cityList;

    //Método para mostrar el último elemento añadido a la lista
    @Override
    public String showLast() {
        return "Ciudad: " + cityList.get(cityList.size()-1).getName() + " Habitantes: " + cityList.get(cityList.size()-1).getPopulation() ;
    }

    //Método para añadir una entrada a la lista
    @Override
    public void addToList(String name, int population) {
        cityList.add(new City(name, population));
    }

    //Método para mostrar la lista de todas las ciudades que componen la lista
    @Override
    public void showList() {
        for (City city : cityList) {
            System.out.println("Ciudad: " + city.getName() + " Habitantes: " + city.getPopulation());
        }
    }

    //Método para escribir la lista de todas las ciudades que componen la lista
    @Override
    public String writeList() {
        String result = "";
        for (City city : cityList) {
            result += "Ciudad: " + city.getName() + " Habitantes: " + city.getPopulation() + "\n";
        }
        return result;
    }
}