package com.example.block16springcloud2nd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaServer
public class Block16SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block16SpringCloudApplication.class, args);
	}

}
