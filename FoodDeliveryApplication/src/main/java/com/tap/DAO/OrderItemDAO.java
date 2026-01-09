package com.tap.DAO;

import java.util.List;


import com.tap.model.OrderItem;

public interface OrderItemDAO {

	
	public int addOrderItem(OrderItem orderItem);
	public OrderItem getOrder(int id);
	public void updateOrder(OrderItem orderItem);
	public void deleteOrder(int id);
	public List<OrderItem> getAllOrderItems();
	public List<OrderItem> getAllOrdersByOrderItemId(int id);
}
