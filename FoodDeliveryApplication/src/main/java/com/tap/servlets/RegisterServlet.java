package com.tap.servlets;

import java.io.IOException;

import com.tap.DAO.*;
import com.tap.DAOImpl.*;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1. Read form data
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email    = req.getParameter("email");
        String address  = req.getParameter("address");
        String phone    = req.getParameter("phonenumber");
        String role     = req.getParameter("role");

        UserDAO userDAOImpl = new UserDAOImpl();

        // 2. Check if email already exists
        User existingUser = userDAOImpl.getUserByEmail(email);

        if (existingUser != null) {
            // Email already registered
        	resp.sendRedirect("login.jsp");
            return;
        }

        // 3. Create new User object
        User user = new User();
        user.setUserName(username);
        user.setPassword(password); // plain text for now (basic project)
        user.setEmail(email);
        user.setAddress(address);
        user.setPhoneNumber(phone);
        user.setRole(role);

        // 4. Insert user
        userDAOImpl.addUser(user);

        // 5. Redirect to login page
        resp.sendRedirect("login.jsp");
    }
}
