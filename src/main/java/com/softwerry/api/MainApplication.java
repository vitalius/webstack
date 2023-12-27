package com.softwerry.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.softwerry.api"})
@EntityScan("com.softwerry.model")
@EnableJpaRepositories("com.softwerry.repository")
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class);
	}
}