package com.pratap.unittesting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratap.unittesting.models.Item;
import com.pratap.unittesting.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-hardcoaded-by-service")
	public Item getItem() {
		return itemService.retrieveHardCodedItem();
	}
}
