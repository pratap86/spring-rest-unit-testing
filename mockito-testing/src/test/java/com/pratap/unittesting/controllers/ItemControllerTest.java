package com.pratap.unittesting.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pratap.unittesting.models.Item;
import com.pratap.unittesting.service.ItemService;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Test
	void testGetDummyItemBasic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/items/dummy-item").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
							.andReturn();
	}
	
	@Test
	void testGetItemBasic() throws Exception {

		when(itemService.retrieveHardCodedItem()).thenReturn(new Item(2, "item2", 100, 2));
		RequestBuilder request = MockMvcRequestBuilders.get("/items/item-hardcoaded-by-service").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json("{id : 2,name : item2, price : 100, quantity : 2}"))
							.andReturn();
	}

}
