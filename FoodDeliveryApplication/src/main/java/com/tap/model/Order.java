package com.tap.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private int OrderId;
	private int UserId;
	private int RestaurantId;
	private String Address;
	private double TotalAmount;
	private Timestamp OrderDate;
	private String Status;
	private String PaymentMethod;
	
	private List<OrderItem> orderItems;
	
	
	
	public Order() {
		this.OrderDate = new Timestamp(System.currentTimeMillis());
		this.orderItems = new ArrayList<>();
	}


	public Order( int userId, int restaurantId, String address, double totalAmount, Timestamp orderDate,
			String status, String paymentMethod) {
		super();
		
		UserId = userId;
		RestaurantId = restaurantId;
		Address = address;
		TotalAmount = totalAmount;
		OrderDate = orderDate;
		Status = status;
		PaymentMethod = paymentMethod;
	}
	
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantID(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public Timestamp getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		OrderDate = orderDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}


	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderId + ", UserID=" + UserId + ", RestaurantID=" + RestaurantId + ", Address="
				+ Address + ", TotalAmount=" + TotalAmount + ", OrderDate=" + OrderDate + ", Status=" + Status
				+ ", PaymentMethod=" + PaymentMethod + "]";
	}
	
	
	
}
