<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register | Food Delivery App</title>

    <!-- Link CSS -->
    <link rel="stylesheet" href="css/register.css">
</head>
<body>

<div class="register-container">
    <h2>Create an Account</h2>

    <form action="RegisterServlet" method="post">

        <div class="form-group">
            <label>Username</label>
            <input type="text" name="username" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required>
        </div>

        <div class="form-group">
            <label>Address</label>
            <textarea name="address" rows="3" required></textarea>
        </div>

        <div class="form-group">
            <label>Phone Number</label>
            <input type="text" name="phone" required>
        </div>

        <div class="form-group">
            <label>Role</label>
            <select name="role" required>
                <option value="">-- Select Role --</option>
                <option value="CUSTOMER">Customer</option>
                <option value="RESTAURANT_ADMIN">Restaurant Admin</option>
                <option value="SUPER_ADMIN">Super Admin</option>
                <option value="DELIVERY_AGENT">Delivery Agent</option>
            </select>
        </div>

        <button type="submit" class="register-btn">Register</button>

    </form>

    <p class="login-link">
        Already have an account?
        <a href="login.jsp">Login</a>
    </p>
</div>

</body>
</html>
