package com.cognizant.rest.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.rest.Country;
import com.cognizant.rest.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countryList = (List) context.getBean("countryList");
		
		for(Country country: countryList)
		{
			String countryCode = country.getCode();
			if(countryCode.equalsIgnoreCase(code))
			{
				return country;
			}
		}
		
		
		throw new CountryNotFoundException("No country with such code found");
	}
}
