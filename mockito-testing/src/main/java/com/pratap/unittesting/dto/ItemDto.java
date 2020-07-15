package com.pratap.unittesting.dto;

import java.io.Serializable;

public class ItemDto implements Serializable {

	private static final long serialVersionUID = -8007294519895243177L;
	
	private int id;
	private String name;
	private int price;
	private int quantity;
	private int value;
	
	public ItemDto() {}
	
	public ItemDto(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
