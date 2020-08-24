package com.pratap.unittesting.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pratap.unittesting.dto.ItemDto;
import com.pratap.unittesting.entities.ItemEntity;
import com.pratap.unittesting.models.ItemResponseModel;
import com.pratap.unittesting.repos.ItemRepository;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

	@InjectMocks
	private ItemServiceImpl itemServiceImpl;
	
	@Mock
	private ItemRepository itemRepository;
	
	List<ItemEntity> entities;
	
	
	@BeforeEach
	public void before() {
		entities = Arrays.asList(new ItemEntity(1, "item1", 100, 1), new ItemEntity(2, "item2", 300, 2));
	}
	
	@Test
	void testRetrieveHardCodedItem() {
		ItemResponseModel itemRespModel = new ItemResponseModel(101, "iPhone", 1000, 1);
		ItemResponseModel item = itemServiceImpl.retrieveHardCodedItem();
		assertEquals(item.getName(), itemRespModel.getName());
	}
	
	@Test
	public void testGetItems() {
		when(itemRepository.findAll()).thenReturn(entities);
		List<ItemDto> items = itemServiceImpl.getItems();
		assertEquals(items.get(0).getValue(), entities.get(0).getValue());
		assertEquals(items.get(1).getValue(), entities.get(1).getValue());
	}
	
	@Test
	public void testCreateItem() {
		ItemDto itemDto = new ItemDto();
		itemDto.setName("test");
		itemDto.setPrice(2000);
		itemDto.setQuantity(1);
		when(itemRepository.save(Mockito.any())).thenReturn(new ItemEntity(101, "test", 2000, 1));
		ItemDto createdItem = itemServiceImpl.createItem(itemDto);
		assertEquals(createdItem.getId(), 101);
		
	}

}
