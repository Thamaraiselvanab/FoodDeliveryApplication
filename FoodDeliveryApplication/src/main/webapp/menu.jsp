<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List,com.tap.model.Menu"  %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Restaurant Menu</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css">
  
</head>
<body>

  <!-- Menu Container -->
  <main class="menu-container">

	<%
		List<Menu> allMenusByRestaurant = (List<Menu>)request.getAttribute("allMenusByRestaurant");
		for (Menu menu : allMenusByRestaurant) {
		%>
			<!-- Single Menu Item -->
		    <div class="menu-card">
		      <img src="<%= menu.getImageUrl() %>" alt="<%=menu.getItemName() %>">

		      <div class="menu-info">
		        <h3 class="menu-name"><%=menu.getItemName() %></h3>

		        <p class="menu-description">
		         <%=menu.getDescription() %>
		        </p>

		        <div class="menu-meta">
		          <span class="menu-price"><%=menu.getPrice() %></span>
		          <span class="menu-rating">⭐ <%= menu.getRating() %></span>
		        </div>
				
				<form action="cart">
				
				<input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
				<input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId()%>">
				<input type="hidden" name="quantity" value="1">
				<input type="hidden" name="action" value="add">
				<input type="submit" value="Add to cart">
				</form>
				 
				
				
		        
		      </div>
		    </div>
		    
	<% }
	%>



















    

    
    

  </main>

</body>
</html>
