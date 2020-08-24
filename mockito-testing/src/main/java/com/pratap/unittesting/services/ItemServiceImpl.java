package com.pratap.unittesting.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.entities.ItemEntity;
import com.pratap.unittesting.models.ItemResponseModel;
import com.pratap.unittesting.repos.ItemRepository;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public ItemResponseModel retrieveHardCodedItem() {
		return new ItemResponseModel(101, "iPhone", 1000, 1);
	}

	@Override
	public List<ItemDto> getItems() {

		List<ItemEntity> items = itemRepository.findAll();
		items.forEach(item -> {
			item.setValue(item.getPrice() * item.getQuantity());
		});
		
		modelMapper = new ModelMapper();
		
		return items.stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
	}

	@Override
	public ItemDto createItem(ItemDto itemDto) {
		
		modelMapper = new ModelMapper();
		ItemEntity itemEntity = modelMapper.map(itemDto, ItemEntity.class);
		ItemEntity savedEntity = itemRepository.save(itemEntity);
		savedEntity.setValue(savedEntity.getPrice() *  savedEntity.getQuantity());
		return modelMapper.map(savedEntity, ItemDto.class);
	}

}
