package com.api;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class CollegeDataApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(CollegeDataApi1Application.class, args);
		log.info("Application is Started...");
		System.err.println("Application Started");
	}

}
