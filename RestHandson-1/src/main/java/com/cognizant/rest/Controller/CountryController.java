package com.cognizant.rest.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.Country;
import com.cognizant.rest.service.CountryService;
import com.cognizant.rest.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;
	
	
	@RequestMapping(value = "/country",method = RequestMethod.GET)
	public Country getCountryIndia()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("in", Country.class);
		
		//return ResponseEntity.of(Optional.of(country));
		
		return country;
		
	}
	
	@GetMapping()
	public List<Country> getAllCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> country = (List) context.getBean("countryList");
		
		return country;
	}
	
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		Country country = countryService.getCountry(code);
		return country;

	}
	
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country)
	{
//		LOGGER.info("Starting post method");
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//
//		Validator validator = factory.getValidator();
//
//		// Validation is done against the annotations defined in country bean
//
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//
//		List<String> errors = new ArrayList<String>();
//
//		// Accumulate all errors in an ArrayList of type String
//
//		for (ConstraintViolation<Country> violation : violations) {
//
//		errors.add(violation.getMessage());
//
//		}
//
//		// Throw exception so that the user of this web service receives appropriate error message
//
//		if (violations.size() > 0) {
//
//		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//
//		}
		LOGGER.debug("Country:{}",country);
		
		return country;
	}
}
