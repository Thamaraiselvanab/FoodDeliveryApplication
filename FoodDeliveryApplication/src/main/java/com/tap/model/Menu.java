package com.tap.model;

import java.sql.Timestamp;

public class Menu {

	private int MenuId;
	private int RestaurantId;
	private String itemName;
	private String Description;
	private int Price;
	private float Rating;
	private String ImageUrl;
	private String Type;
	private int isAvailable;
	public Menu(int menuId, int restaurantId, String itemName, String description, int price, float rating,
			String imageUrl, String type, int isAvailable) {
		super();
		this.MenuId = menuId;
		this.RestaurantId = restaurantId;
		this.itemName = itemName;
		this.Description = description;
		this.Price = price;
		this.Rating = rating;
		this.ImageUrl = imageUrl;
		this.Type = type;
		this.isAvailable = isAvailable;
	}
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Menu [MenuId=" + MenuId + ", RestaurantId=" + RestaurantId + ", itemName=" + itemName + ", Description="
				+ Description + ", Price=" + Price + ", Rating=" + Rating + ", ImageUrl=" + ImageUrl + ", Type=" + Type
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
}
