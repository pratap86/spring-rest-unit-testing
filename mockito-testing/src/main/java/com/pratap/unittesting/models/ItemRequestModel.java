package com.pratap.unittesting.models;

public class ItemRequestModel {

	private int id;
	private String name;
	private int price;
	private int quantity;

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, price=%s, quantity=%s]", id, name, price, quantity);
	}
	
}
