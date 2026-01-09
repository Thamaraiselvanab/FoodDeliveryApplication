<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List,com.tap.model.Restaurant"  %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Restaurant List</title>

  <!-- CSS -->
  
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/restaurant.css">
	

</head>
<body>



  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="nav-brand">🍔 Food Delivery App</div>
	

    <!-- Hamburger icon for small screens -->
    <div class="nav-toggle" onclick="toggleMenu()">
      ☰
    </div>

    <div class="nav-menu">
      <!-- Search -->
      <form class="nav-search" action="#" method="get">
        <input type="text" name="query" placeholder="Search restaurants…">
        <button type="submit">Search</button>
      </form>

      <!-- Links -->
      <a href="#">Home</a>
      <a href="login.jsp">Login</a>
      <a href="#">Profile</a>
      <a href="cart.jsp">Cart</a>
      
      <a href="#" class="order-btn">Order Now</a>
    </div>
  </nav>

  <!-- Restaurant Cards Container -->
  <main class="cards-container">
  
  	<%
  	
  	List<Restaurant> allRestaurants = (List<Restaurant>)request.getAttribute("allRestaurants");
    		for (Restaurant restaurant : allRestaurants) {
    	%>	
    	<a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">
    			<div class="card">
    		      <img src="<%= restaurant.getImageUrl() %>" alt="Restaurant Image">
    		      <div class="card-info">
    		        <h3 class="name"><%= restaurant.getRestaurantName() %></h3>
    		        <p class="location">📍<%= restaurant.getAddress() %></p>
    		        <div class="details">
    		          <span class="rating">⭐<%= restaurant.getRating() %></span>
    		          <span class="time"><%= restaurant.getDeliveryTime() %></span>
    		        </div>
    		        <p class="description"><%= restaurant.getCuisineType() %></p>
    		      </div>
    		    </div>
    	</a>	
    			
    			
    <%	}
  	%>
  
  
  
    <!-- Cards go here -->
    
  </main>

  <!-- Responsive toggle script -->
  <script>
    function toggleMenu() {
      const menu = document.querySelector('.nav-menu');
      menu.classList.toggle('active');
    }
  </script>

</body>
</html>
