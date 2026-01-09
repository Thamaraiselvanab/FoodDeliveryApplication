package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.model.User;
import com.tap.utility.DBconnection;

public class RestaurantDAOImpl implements RestaurantDAO{

	String INSERT_RESTAURANT = "INSERT into restaurant (restaurantId, restaurantname, adminuserid, address, cuisinetype, imageurl,rating, isactive, deliverytime) "
			+"values(?,?,?,?,?,?,?,?,?)";
	
	String GET_RESTAURANT_BY_ID = "SELECT * FROM Restaurant where restaurantid=?";
	
	String UPDATE_RESTAURANT = "Update Restaurant Set restaurantID=?, restaurantName=?, adminuserid=?, address=?, cuisinetype=?, imageurl=?, rating=?, isactive=?, deliverytime=? where restaurantId=?";
	
	String DELETE_RESTAURANT = "Delete from Restaurant where restaurantid=?;";
	
	String GET_ALL_RESTAURANT = "Select * from Restaurant";
	
	
	
	
	
	@Override
	public int addRestaurant(Restaurant res) {
		
		int result=0;;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_RESTAURANT);) 
		{
			pstmt.setInt(1, res.getRestaurantID());
			pstmt.setString(2, res.getRestaurantName());
			pstmt.setInt(3, res.getAdminID());
			pstmt.setString(4, res.getAddress());
			pstmt.setString(5, res.getCuisineType());
			pstmt.setString(6, res.getImageUrl());
			pstmt.setFloat(7, res.getRating());
			pstmt.setString(8,  res.getIsActive());
			pstmt.setInt(9,  res.getDeliveryTime());
			
			 result= pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant res=null;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_RESTAURANT_BY_ID);) 
		{
			
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) 
			{
				int restaurantID = result.getInt("restaurantId");
				String restaurantName = result.getString("restaurantName");
				int adminID = result.getInt("adminuserID");
				String address = result.getString("address");
				String cuisineType = result.getString("cuisineType");
				String imageUrl = result.getString("imageUrl");
				float rating = result.getFloat("rating");
				String isActive = result.getString("isActive");
				int deliveryTime=result.getInt("deliveryTime");
				
				
				res = new Restaurant(restaurantID, restaurantName, adminID, address, cuisineType, imageUrl, rating, isActive, deliveryTime);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void updateRestaurant(Restaurant res) {
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(UPDATE_RESTAURANT);)
		{
			pstmt.setInt(1, res.getRestaurantID());
			pstmt.setString(2, res.getRestaurantName());
			pstmt.setInt(3, res.getAdminID());
			pstmt.setString(4, res.getAddress());
			pstmt.setString(5, res.getCuisineType());
			pstmt.setString(6, res.getImageUrl());
			pstmt.setFloat(7, res.getRating());
			pstmt.setString(8, res.getIsActive());
			pstmt.setInt(9, res.getDeliveryTime());
			pstmt.setInt(10, res.getRestaurantID());
			
			pstmt.executeUpdate();
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}
	@Override
	public void deleteRestaurant(int id) {
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(DELETE_RESTAURANT);)
		{
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		List<Restaurant> listOfRestaurant = new ArrayList<>();
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(GET_ALL_RESTAURANT);)
		{
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) 
			{
				int restaurantID = result.getInt("restaurantId");
				String restaurantName = result.getString("restaurantName");
				int adminID = result.getInt("adminuserID");
				String address = result.getString("address");
				String cuisineType = result.getString("cuisineType");
				String imageUrl = result.getString("imageUrl");
				float rating = result.getFloat("rating");
				String isActive = result.getString("isActive");
				int deliveryTime=result.getInt("deliveryTime");
				
				
				Restaurant res = new Restaurant(restaurantID, restaurantName, adminID, address, cuisineType, imageUrl, rating, isActive, deliveryTime);
				listOfRestaurant.add(res);
			}
			
			
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		return listOfRestaurant;
	}

}
