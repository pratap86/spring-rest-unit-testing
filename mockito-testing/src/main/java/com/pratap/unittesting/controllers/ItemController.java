package com.pratap.unittesting.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.models.ItemRequestModel;
import com.pratap.unittesting.models.ItemResponseModel;
import com.pratap.unittesting.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private ModelMapper modelMapper;

	@GetMapping("/dummy-item")
	public ItemResponseModel getDummyItem() {
		return new ItemResponseModel(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-hardcoaded-by-service")
	public ItemResponseModel getItem() {
		return itemService.retrieveHardCodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<ItemResponseModel> getItems(){
		
		List<ItemDto> items = itemService.getItems();
		modelMapper = new ModelMapper();
		return items.stream().map(item -> modelMapper.map(item, ItemResponseModel.class)).collect(Collectors.toList());
	}
	
	@PostMapping("/item")
	public ResponseEntity<ItemResponseModel> createItem(@RequestBody ItemRequestModel itemRequestModel) {

		modelMapper = new ModelMapper();
		ItemDto itemDto = modelMapper.map(itemRequestModel, ItemDto.class);
		ItemDto createdItem = itemService.createItem(itemDto);
		ItemResponseModel respValue = modelMapper.map(createdItem, ItemResponseModel.class);

		// return proper status - 201 created & where the new resource is created get
		// URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdItem.getId()).toUri();

		return ResponseEntity.created(location).body(respValue);
	}
}
