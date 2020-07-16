package com.pratap.unittesting.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratap.unittesting.entities.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
