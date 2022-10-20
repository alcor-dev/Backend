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
public class Block5ProfilesApplication implements CommandLineRunner {
	@Autowired
	Environment environment;

	@Value("${spring.profiles.active}")
	String profile;

//	@Value("${bd.url}")
//	String url;

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}

	@Bean
	@Profile("local")

	CommandLineRunner printLocal() {
		//System.out.println(getProfile());
		return local -> {
			System.out.println("EL perfil actual es: " + getProfile());
		};
	}

	@Bean
	@Profile("PRO")
	CommandLineRunner printPro() {
		//System.out.println(getProfile());
		return local -> {
			System.out.println("EL perfil actual es: " + getProfile());
		};
	}

	@Bean
	@Profile("INT")
	CommandLineRunner printInt() {
		System.out.println(getProfile());
		return local -> {
			System.out.println("El perfil actual es: " + getProfile());
		};
	}

	@Bean
	@Profile({"TEST"})
	CommandLineRunner printTest() {
		System.out.println(getProfile());
		return local -> {
			System.out.println("TEST");
		};
	}

	@Override
	public void run(String... args) throws Exception {
//		showProfiles();
		System.out.println("La variable perfil ahora mismo es: " + profile);
		getData();
	}

	String getProfile(){
		System.out.println(environment.getActiveProfiles());
		String[] profiles = environment.getActiveProfiles();
		return profiles.length>0?profiles[0]:"default";
	}

	void getData(){
		String dbUrl = environment.toString();
		System.out.println(dbUrl);
	}

	void showProfiles() {
		String[] profiles = environment.getActiveProfiles();
		for (int i = 0; i < profiles.length; i++) {
			System.out.println(profiles[i]);
		}
	}
}
