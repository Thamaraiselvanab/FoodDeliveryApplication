package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DAOImpl.OrderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		int restaurantId = (Integer)session.getAttribute("oldRestaurantId");
		
		
		String address = req.getParameter("address");
		String paymentMethod = req.getParameter("paymentMethod");
		
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			return;
		}
		
		if (address == null || address.trim().isEmpty()
                || paymentMethod == null || paymentMethod.trim().isEmpty()) {
            resp.sendRedirect("checkout.jsp");
            return;
        }
		
		if(cart != null && user!=null && !cart.getItems().isEmpty())
		{
			Order order = new Order();
			
			order.setUserId(user.getUserId());
			order.setRestaurantID(restaurantId);
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));
			order.setAddress(address);
			order.setStatus("Pending");
			order.setPaymentMethod(paymentMethod);
			
			double totalAmount = 0.0;
			
			for (CartItem item : cart.getItems().values()) {
				
				totalAmount = totalAmount + item.getQuantity() * item.getPrice();
			}
			
			order.setTotalAmount(totalAmount);
			
			OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
			
			int orderId = orderDAOImpl.addOrder(order);
			System.out.println(orderId);
			
			for (CartItem item : cart.getItems().values()) {
				
				int itemId = item.getItemId();
				int quantity = item.getQuantity();
				double totalPrice = item.getTotalPrice();
				
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderId(orderId);
				orderItem.setItemId(itemId);
				orderItem.setQuantity(quantity);
				orderItem.setTotalPrice(totalPrice);
				
				OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
				orderItemDAOImpl.addOrderItem(orderItem);
			}
			
			
			session.removeAttribute("cart");
			session.removeAttribute("oldRestaurantId");
			
			resp.sendRedirect("orderconfirmation.html");
			
			
			
		
		}else {
			resp.sendRedirect("cart.jsp");
		}
		
			
			
			
			
			
			
		
	}

}
