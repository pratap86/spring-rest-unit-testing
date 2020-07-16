package com.pratap.unittesting.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.models.ItemResponseModel;
import com.pratap.unittesting.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/dummy-item")
	public ItemResponseModel getDummyItem() {
		return new ItemResponseModel(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-hardcoaded-by-service")
	public ItemResponseModel getItem() {
		return itemService.retrieveHardCodedItem();
	}
	
	@GetMapping("/item-jpa-by-service")
	public List<ItemResponseModel> getItems(){
		
		List<ItemDto> items = itemService.getItems();
		return items.stream().map(item -> modelMapper.map(item, ItemResponseModel.class)).collect(Collectors.toList());
	}
}
