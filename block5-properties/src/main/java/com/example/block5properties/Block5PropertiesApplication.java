package com.example.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block5PropertiesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);
	}

	//Cogemos el valor greeting del archivo application.properties llamándolo primero con $
	//para luego poner la variable entre llaves {}
	//Esto hace que al poner después una declaración de variable, esta sea asignada automáticamente
	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private String myNumber;

	@Value("${new.property}")
	private String newProperty;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es: " + greeting);
		System.out.println("El valor de my.number es: " + myNumber);
		System.out.println("El valor de new.property es: " + newProperty);
	}
}