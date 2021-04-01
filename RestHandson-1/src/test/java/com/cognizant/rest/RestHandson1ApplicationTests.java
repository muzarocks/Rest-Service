package com.cognizant.rest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.rest.Controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class RestHandson1ApplicationTests {

	@Autowired
	private CountryController countryController;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		
		assertNotNull(countryController);
	}
	
	@Test
	public void testGetCountry() throws Exception {

	ResultActions actions = mvc.perform(get("/country"));
	actions.andExpect(status().isOk());
	
	actions.andExpect(jsonPath("$.code").exists());

	actions.andExpect(jsonPath("$.code").value("IN"));
	actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	
	public void testGetCountryException() throws Exception{
		ResultActions actions = mvc.perform(get("/country/az"));
		
		actions.andExpect(status().isBadRequest());

		actions.andExpect(status().reason("Country Not found"));
	}

}
