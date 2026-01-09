package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.utility.DBconnection;

public class MenuDAOImpl implements MenuDAO{

	String INSERT_MENU = "INSERT into menu (menuId, restaurantId, itemname, description, price, rating, imageurl,type, isAvailable) "
			+"values(?,?,?,?,?,?,?,?,?)";
	
	String GET_MENU_BY_ID = "SELECT * FROM menu where menuId=?";
	
	String UPDATE_MENU = "Update menu Set menuID=?,restaurantId=?, itemName=?, description=?, price=?, rating=?, imageurl=?, type=?, isAvailable=? where menuId=?";
	
	String DELETE_MENU = "Delete from menu where menuId=?";
	
	String GET_ALL_MENU = "Select * from menu";
	
	String GET_ALL_MENU_BY_RESTAURANTID ="Select * from menu where restaurantId=?";
	
	
	@Override
	public int addMenu(Menu menu) {
		
		int result=0;;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_MENU);) 
		{
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2, menu.getRestaurantId());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setInt(5, menu.getPrice());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setString(7, menu.getImageUrl());
			pstmt.setString(8,  menu.getType());
			pstmt.setInt(9,  menu.getIsAvailable());
			
			 result= pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Menu getMenu(int id) {
		
		Menu menu=null;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_MENU_BY_ID);) 
		{
			
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) 
			{
				int menuID = result.getInt("menuID");
				int restaurantID = result.getInt("restaurantId");
				String itemName = result.getString("itemName");
				String description = result.getString("description");
				int price = result.getInt("price");
				float rating = result.getFloat("rating");
				String imageUrl = result.getString("imageUrl");
				String type = result.getString("type");
				int isAvailable = result.getInt("isAvailable");
			
				
				menu = new Menu(menuID, restaurantID, itemName, description, price, rating, imageUrl, type, isAvailable);
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(UPDATE_MENU);)
		{
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2, menu.getRestaurantId());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setInt(5, menu.getPrice());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setString(7, menu.getImageUrl());
			pstmt.setString(8,  menu.getType());
			pstmt.setInt(9,  menu.getIsAvailable());
			pstmt.setInt(10, menu.getMenuId());
			
			pstmt.executeUpdate();
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
		
	}

	@Override
	public void deleteMenu(int id) {
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(DELETE_MENU);)
		{
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenus() {
		List<Menu> listOfMenu = new ArrayList<>();
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(GET_ALL_MENU);)
		{
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) 
			{
				int menuID = result.getInt("menuID");
				int restaurantID = result.getInt("restaurantId");
				String itemName = result.getString("itemName");
				String description = result.getString("description");
				int price = result.getInt("price");
				float rating = result.getFloat("rating");
				String imageUrl = result.getString("imageUrl");
				String type = result.getString("type");
				int isAvailable = result.getInt("isAvailable");
				
				
				Menu menu = new Menu(menuID, restaurantID, itemName, description, price, rating, imageUrl, type, isAvailable);
				listOfMenu.add(menu);
			}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return listOfMenu;
}

	@Override
	public List<Menu> getAllMenusByRestaurantId(int id) {
		List<Menu> listOfMenu = new ArrayList<>();
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(GET_ALL_MENU_BY_RESTAURANTID);)
		{
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) 
			{
				int menuId = result.getInt("menuId");
				int restaurantId = result.getInt("restaurantId");
				String itemName = result.getString("itemName");
				String description = result.getString("description");
				int price = result.getInt("price");
				float rating = result.getFloat("rating");
				String imageUrl = result.getString("imageUrl");
				String type = result.getString("type");
				int isAvailable = result.getInt("isAvailable");
				
				
				Menu menu = new Menu(menuId, restaurantId, itemName, description, price, rating, imageUrl, type, isAvailable);
				listOfMenu.add(menu);
			}
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		
		return listOfMenu;
	}
}
