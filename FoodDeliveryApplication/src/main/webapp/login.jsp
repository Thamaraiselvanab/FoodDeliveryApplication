<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login | Food Delivery App</title>
    <link rel="stylesheet" href="css/login.css">
</head>

<body>

<div class="login-container">
    <h2>Login</h2>

    <!-- Error / Attempts Messages -->
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        Integer attemptsLeft = (Integer) request.getAttribute("attemptsLeft");
        Boolean loginBlocked = (Boolean) request.getAttribute("loginBlocked");
    %>

    <% if (errorMessage != null) { %>
        <p class="error"><%= errorMessage %></p>
    <% } %>

    <% if (attemptsLeft != null && attemptsLeft > 0) { %>
        <p class="attempts">
            Attempts left: <%= attemptsLeft %>
        </p>
    <% } %>

    <% if (loginBlocked != null && loginBlocked) { %>
        <p class="blocked">
            Too many failed attempts. Please try again later.
        </p>
    <% } %>

    <!-- Login Form -->
    <form action="login" method="post">

        <input type="email"
               name="email"
               placeholder="Enter Email ID"
               required>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

        <button type="submit" class="login-btn">
            Login
        </button>

    </form>

    <!-- Register Section -->
    <p class="register-text">
        Don’t have an account?
    </p>

    <a href="register.jsp">
        <button type="button" class="register-btn">
            Register
        </button>
    </a>

</div>

</body>
</html>
