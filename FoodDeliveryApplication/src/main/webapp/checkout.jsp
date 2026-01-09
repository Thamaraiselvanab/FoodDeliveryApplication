<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout | Food Delivery App</title>
    <link rel="stylesheet" href="css/checkout.css">
</head>

<body>

<div class="container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">

        <!-- Delivery Address -->
        <label for="address">Delivery Address:</label>
        <textarea id="address"
                  name="address"
                  placeholder="Enter your delivery address"
                  required></textarea>

        <!-- Payment Method -->
        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod"
                name="paymentMethod"
                required>
            <option value="">-- Select Payment Method --</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Cash on Delivery">Cash on Delivery</option>
        </select>

        <!-- Place Order Button -->
        <input type="submit"
               value="Place Order"
               class="place-order-btn">

    </form>
</div>

</body>
</html>
