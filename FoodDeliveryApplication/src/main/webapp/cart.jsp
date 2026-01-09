<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ page import="com.tap.model.Cart, com.tap.model.CartItem, java.util.Map" %>
	
  <meta charset="UTF-8">
  <title>Cart</title>
  <link rel="stylesheet" href="css/cart.css">
</head>
<body>


  <!-- COD PAGE CONTAINER -->
  <div class="cod-container">
    <h2 class="cod-title">🧾 Cart</h2>
		<%
		Cart cart = (Cart) session.getAttribute("cart");
		Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");
		%>
		<% 
		if (cart != null && !cart.getItems().isEmpty()) {
			for (CartItem item : cart.getItems().values()){	
		%>
	 <!-- IF codItems.size() > 0 -->
    <div class="cod-card">

      <!-- COD ITEM -->
      <div class="cod-item">
        <div class="item-info">
          <h4><%=item.getName() %></h4>
          <p> Price: ₹<%=item.getPrice() %></p>
          
        </div>

        <!-- Quantity Controls -->
       <div class="quantity-control">

  <!-- PLUS BUTTON -->
  <form action="cart"  style="display:inline;">
    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
    <button type="submit" class="qty-btn">+</button>
  </form>

  <!-- CURRENT QUANTITY -->
  <span class="qty-value"><%= item.getQuantity() %></span>

  <!-- MINUS BUTTON -->
  <form action="cart"  style="display:inline;">
    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
    <button
      type="submit"
      class="qty-btn"
      <%= (item.getQuantity() == 1) ? "disabled" : "" %>>
      −
    </button>
  </form>

</div>

	<form action="<%= request.getContextPath() %>/cart"
      style="display:inline;">

  <input type="hidden" name="itemId" value="<%= item.getItemId() %>">

  <input type="hidden" name="restaurantId" value="<%= restaurantId %>">

  <input type="hidden" name="action" value="remove">

  <button type="submit" class="remove-btn">
    Remove
  </button>

</form>
	
</div>

     <%
	
	}
     %>
      <!-- TOTAL -->
      <!-- GRAND TOTAL -->
<div class="total">
  Grand Total: ₹<%= cart.getTotalPrice() %>
</div>

<!-- ADD MORE ITEMS -->
<div class="add-more-items">
  <a href="menu?restaurantId=<%= session.getAttribute("oldRestaurantId") %>"
     class="btn add-more-items-btn">
     Add More Items
     
  </a>
</div>



 <% 
   } else{
%>
   
    <!-- ELSE -->
    <div class="empty-cod">
      <h3>No items in your cart</h3>
      <a href="Restaurant" class="add-item-btn">
  Add Items to COD
</a>

    </div>
    <!-- END ELSE -->
	<%
	}
		
	%>
	<%
	if(session.getAttribute("cart")!=null)
	{
	%>	
	
	<form action="checkout.jsp" method="post">
		<input type="submit" value="Proceed to Checkout"
		class="btn proceed-to-checkout-btn">
	</form>
	<%
	}
	%>
	

  </div>

</body>
</html>
