package com.tap.DAO;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {
	
	public int addRestaurant(Restaurant res);
	public Restaurant getRestaurant(int id);
	public void updateRestaurant(Restaurant res);
	public void deleteRestaurant(int id);
	public List<Restaurant> getAllRestaurant();
	
}
