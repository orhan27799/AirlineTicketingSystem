package com.airlineticketingsystem;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AirlineTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AirlineTicketingSystemApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/airlineticketsystem"));
		app.run(args);
	}

}
