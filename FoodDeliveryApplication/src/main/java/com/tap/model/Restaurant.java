package com.tap.model;

import java.sql.Timestamp;

public class Restaurant {
	
	private int RestaurantId;
	private String RestaurantName;
	private int AdminID;
	private String Address;
	private String CuisineType;
	private String ImageUrl;
	private float Rating;
	private String isActive;
	private int DeliveryTime;
	
	
	public Restaurant(int restaurantId, String restaurantName, int adminID, String address, String cuisineType,
			String imageUrl, float rating, String isActive, int deliveryTime) {
		super();
		RestaurantId = restaurantId;
		RestaurantName = restaurantName;
		AdminID = adminID;
		Address = address;
		CuisineType = cuisineType;
		ImageUrl = imageUrl;
		Rating = rating;
		this.isActive = isActive;
		DeliveryTime = deliveryTime;
	}


	public int getRestaurantId() {
		return RestaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return RestaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}


	public int getAdminID() {
		return AdminID;
	}


	public void setAdminID(int adminID) {
		AdminID = adminID;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getCuisineType() {
		return CuisineType;
	}


	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}


	public String getImageUrl() {
		return ImageUrl;
	}


	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}


	public float getRating() {
		return Rating;
	}


	public void setRating(float rating) {
		Rating = rating;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public int getDeliveryTime() {
		return DeliveryTime;
	}


	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}


	@Override
	public String toString() {
		return "Restaurant [RestaurantID=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", AdminID="
				+ AdminID + ", Address=" + Address + ", CuisineType=" + CuisineType + ", ImageUrl=" + ImageUrl
				+ ", Rating=" + Rating + ", isActive=" + isActive + ", DeliveryTime=" + DeliveryTime + "]";
	}
	
	
	
}
