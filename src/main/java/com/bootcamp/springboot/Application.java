package com.bootcamp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@ConfigurationPropertiesScan("com.bootcamp.springboot")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
