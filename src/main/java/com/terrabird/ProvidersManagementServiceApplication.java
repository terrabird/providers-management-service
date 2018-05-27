package com.terrabird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProvidersManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidersManagementServiceApplication.class, args);
	}
}
