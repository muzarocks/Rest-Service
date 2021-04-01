package com.cognizant.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestHandson2Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestHandson2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RestHandson2Application.class, args);
	}

}
