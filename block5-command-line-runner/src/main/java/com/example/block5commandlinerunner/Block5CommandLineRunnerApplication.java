package com.example.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//En la siguiente línea, se ejecutarán los métodos introducidos dentro del run del CommandLineRunner
		//Depende del orden en que se pongan así se ejecutarán
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@Override
	//Ponemos aquí los métodos de CommandLineRunner que hemos escrito tras este método
	//Ello ayudará a poner en orden las cosas
	public void run(String... args) throws Exception {
		secondSalute();
		thirdSalute(args);
	}

	//Usamos PostConstruct como primer saludo
	//Al ser PostConstruct se ejecutará independientemente de si lo metemos en el run o no
	@PostConstruct
	public static void firstSalute() {
		System.out.println("Hola desde la clase inicial");
	}

	@Bean
	//Creamos el primer método CommandLineRunner
	//Usamos un bean como en el ejemplo para tener una base desde donde empezar
	//Hacemos que devuelva una lambda sencilla
	CommandLineRunner secondSalute() {
		return salute -> {
			System.out.println("Saludos desde clase secundaria");
		};
	}

	@Bean
	//Mismo que lo anterior
	CommandLineRunner thirdSalute(String[] args) {
		//Convertimos a lista los args recibidos para poder tratarlos mejor posteriormente
		List<String> arguments = Arrays.stream(args).toList();

		return salute -> {
			//Código original antes de la modificación
			System.out.println("Soy la tercera clase");

			//En caso de que haya args, se imprimirán todos en sucesión
			//Si no hay no imprimirá nada
			arguments.forEach(System.out::println);
		};
	}
}