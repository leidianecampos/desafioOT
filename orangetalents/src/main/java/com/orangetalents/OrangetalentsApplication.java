package com.orangetalents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.orangetalents.repository")
@SpringBootApplication
public class OrangetalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangetalentsApplication.class, args);
	}

}
