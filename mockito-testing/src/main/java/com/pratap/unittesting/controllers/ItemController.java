package com.pratap.unittesting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratap.unittesting.models.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}
}
