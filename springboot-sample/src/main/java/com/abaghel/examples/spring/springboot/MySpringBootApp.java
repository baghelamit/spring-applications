package com.abaghel.examples.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MySpringBootApp extends SpringBootServletInitializer {

	//For deploying as war file
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MySpringBootApp.class);
	}
	
	//springboot standalone
	public static void main(String[] args) {
		SpringApplication.run(new Object[] { MySpringBootApp.class }, args);
	}
}
