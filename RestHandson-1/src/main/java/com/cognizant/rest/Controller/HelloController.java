package com.cognizant.rest.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.RestHandson1Application;

@RestController
public class HelloController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestHandson1Application.class);

	@GetMapping("/hello")
	public String sayHello()
	{
		LOGGER.info("Start");

		return "Hello World";
		
	}
}
