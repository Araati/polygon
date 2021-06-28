package com.araati.polygon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PolygonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolygonApplication.class, args);
	}

}
