package com.pratap.unittesting.services;

import java.util.List;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.models.ItemResponseModel;

public interface ItemService {

	ItemResponseModel retrieveHardCodedItem();
	
	List<ItemDto> getItems();
}
