package com.tap.DAO;

import java.util.List;

import com.tap.model.Order;

public interface OrderDAO {
	public int addOrder(Order order);
	public Order getOrder(int id);
	public void updateOrder(Order order);
	public void deleteOrder(int id);
	public List<Order> getAllOrders();
	public List<Order> getAllOrdersByOrderId(int id);
}
