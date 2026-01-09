package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.utility.DBconnection;

public class OrderItemDAOImpl implements OrderItemDAO{

	String ADD_ORDERITEM = "INSERT into orderitem (orderId, itemId, quantity, totalPrice) "
			+"values(?,?,?,?)";
	
	@Override
	public int addOrderItem(OrderItem orderItem) {
		
		int orderItemId=0;
		try(Connection connection =DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(ADD_ORDERITEM, Statement.RETURN_GENERATED_KEYS);) 
		{
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getItemId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getTotalPrice());
			
			
			int affectedRows = pstmt.executeUpdate();
			if(affectedRows == 0)
			{
				throw new SQLException("Creating orderItemId failed, no rows affected");
			}
			 
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if(generatedKeys.next())
			{
				orderItemId = generatedKeys.getInt(1);
			}else {
				throw new SQLException("Creating orderItemId failed, no ID obtained");
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return orderItemId;
	}

	@Override
	public OrderItem getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getAllOrdersByOrderItemId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
