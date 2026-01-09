package com.tap.model;

public class OrderItem {

	private int OrderItemId;
	private int OrderId;
	private int ItemId;
	private int Quantity;
	private double TotalPrice;
	
	public OrderItem() {
		super();
	}
	public OrderItem( int orderId, int itemId, int quantity, double totalPrice) {
		super();
		
		OrderId = orderId;
		ItemId = itemId;
		Quantity = quantity;
		TotalPrice = totalPrice;
	}
	public int getOrderItemId() {
		return OrderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		OrderItemId = orderItemId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	
	
		
	
}
