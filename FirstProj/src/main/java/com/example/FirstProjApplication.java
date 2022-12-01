package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(FirstProjApplication.class, args);
		System.out.println("Hello world");
		
	   Alien a1 = context.getBean(Alien.class);
	   a1.show();
	}

}
