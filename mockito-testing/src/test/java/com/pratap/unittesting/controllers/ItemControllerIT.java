package com.pratap.unittesting.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() throws JSONException {
		
		String response = this.restTemplate.getForObject("/items/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{name : iPhone}, {name : iPad}, {name : iTv}]", response, false);
	}

}
