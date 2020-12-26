package com.learn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppWsApplication.class, args);
	}

}
