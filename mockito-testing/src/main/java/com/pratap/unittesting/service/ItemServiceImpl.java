package com.pratap.unittesting.service;

import org.springframework.stereotype.Service;

import com.pratap.unittesting.models.Item;
@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public Item retrieveHardCodedItem() {
		return new Item(101, "iPhone", 1000, 1);
	}

}
