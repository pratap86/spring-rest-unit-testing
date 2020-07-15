package com.pratap.unittesting.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.models.ItemResponseModel;
import com.pratap.unittesting.services.ItemService;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	private List<ItemDto> items;
	
	@BeforeEach
	public void before() {
		items = Arrays.asList(new ItemDto(1, "item1", 100, 1), new ItemDto(2, "item2", 200, 2));
	}
	
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

		when(itemService.retrieveHardCodedItem()).thenReturn(new ItemResponseModel(2, "item2", 100, 2));
		RequestBuilder request = MockMvcRequestBuilders.get("/items/item-hardcoaded-by-service").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json("{id : 2,name : item2, price : 100, quantity : 2}"))
							.andReturn();
	}
	
	@Test
	void testGetItemsBasic() throws Exception {

		when(itemService.getItems()).thenReturn(items);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/items/item-jpa-by-service").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json("[{id : 1,name : item1, price : 100, quantity : 1}, {id : 2,name : item2, price : 200, quantity : 2}]"))
							.andReturn();
	}

}
