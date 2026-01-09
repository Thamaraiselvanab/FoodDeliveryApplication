package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class CartItem {
	private int itemId;
	private String name;
	private int quantity;
	private double price;
	
	private Map<Integer, CartItem> items;
	
public CartItem() {
		
		this.items = new HashMap<>();
	}

	
	public CartItem(int itemId, String name, int quantity, double price) {
		super();
		this.items = new HashMap<>();
		this.itemId = itemId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setNameString(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public double getTotalPrice()
	{
		double totalPrice=0.0;
		for (CartItem item : items.values()) {
			
			totalPrice =totalPrice+ item.getQuantity()*item.getPrice();
			
		}
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", nameString=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
	
}
