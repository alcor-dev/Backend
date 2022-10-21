package com.example.block5profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Configuration
@PropertySources({
		@PropertySource("classpath:application-int.properties"),
		@PropertySource("classpath:application-pro.properties")
})
public class Block5ProfilesApplication implements CommandLineRunner {
	//Usamos Autowired para que nos haga las conexiones oportunas con las variables de entorno
	@Autowired
	Environment environment;

	//Asignamos el valor correspondiente al perfil en el que nos encontramos
	//El valor se cogerá según el entorno asignado mediante parámetros en la cadena de comandos
	@Value("${spring.profiles.active}")
	String profile;

	//Guardamos otro valor guardado en el archivo application.configuration correspondiente
	@Value("${bd.url}")
	String url;

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	//Creamos un Bean y le decimos que ejecute X código cuando coincida con un perfil concreto
	@Bean
	@Profile("local")

	//Creamos un CommandLineRunner que nos devuelva tanto el perfil como su bd.url
	CommandLineRunner printLocal() {
		return local -> {
			System.out.println("EL perfil actual es: " + getProfile() + " y la URL es: " + url);
		};
	}

	@Bean
	@Profile("PRO")
	CommandLineRunner printPro() {
		return local -> {
			System.out.println("EL perfil actual es: " + getProfile() + " y la URL es: " + url);
		};
	}

	@Bean
	@Profile("INT")
	CommandLineRunner printInt() {
		return local -> {
			System.out.println("EL perfil actual es: " + getProfile() + " y la URL es: " + url);
		};
	}

	@Override
	public void run(String... args) throws Exception {
	}

	//Pequeño código para obtener los perfiles actuales
	String getProfile(){
		System.out.println(environment.getActiveProfiles());
		String[] profiles = environment.getActiveProfiles();
		return profiles.length>0?profiles[0]:"default";
	}
}
