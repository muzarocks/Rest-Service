package com.cognizant.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RestHandson1Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestHandson1Application.class);
	
	public static void displayDate()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		Date date = null;
		try {
		 date = format.parse("31/12/2018");
		}
		catch(Exception e)
		{
			System.out.println("Exception happened");
		}
		
		LOGGER.debug("Date object after parsing:"+date);
		
		LOGGER.info("End");
	}
	
	private static void displayCountry()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);
		
		Country anotherCountry = context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("End");

	}
	
	public static void displayCountries()
	{
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		List<Country> countryList = (List) context.getBean("countryList");
		
		LOGGER.debug("countryList:: {}",countryList);
		
		LOGGER.info("End");
		

	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestHandson1Application.class, args);
		
		//displayDate();
		
		//displayCountry();
		
		//displayCountries();
	}

}
