package com.pratap.unittesting.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pratap.unittesting.entities.ItemEntity;

@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	void testFindAll() {
		
		List<ItemEntity> items = itemRepository.findAll();
		assertEquals(10, items.size());
	}

}
