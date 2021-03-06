package com.pratap.unittesting.models;

public class ItemResponseModel {

	private int id;
	private String name;
	private int price;
	private int quantity;
	private int value;
	
	public ItemResponseModel() {
	}
	
	public ItemResponseModel(int id, String name, int price, int quantity) {
		super();
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
	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, price=%s, quantity=%s]", id, name, price, quantity);
	}
	
}
