package com.tap.DAOImpl;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.model.Order;
import com.tap.utility.DBconnection;

public class OrderDAOImpl  implements OrderDAO {

	String ADD_ORDER = "INSERT into orders (userId, restaurantId, address, totalAmount, orderDate, status, paymentMethod) "
			+"values(?,?,?,?,?,?,?)";
	
	@Override
	public int addOrder(Order order) {
		
		int orderId=0;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);) 
		{
			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setString(3, order.getAddress());
			pstmt.setDouble(4, order.getTotalAmount());
			pstmt.setTimestamp(5, order.getOrderDate());
			pstmt.setString(6, order.getStatus());
			pstmt.setString(7, order.getPaymentMethod());
			
			int affectedRows = pstmt.executeUpdate();
			System.out.println("Affected rows: " + affectedRows);

			if(affectedRows == 0)
			{
				throw new SQLException("Creating order failed, no rows affected");
			}
			 
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if(generatedKeys.next())
			{
				orderId = generatedKeys.getInt(1);
			}else {
				throw new SQLException("Creating order failed, no ID obtained");
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return orderId;
		
		
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrdersByOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
