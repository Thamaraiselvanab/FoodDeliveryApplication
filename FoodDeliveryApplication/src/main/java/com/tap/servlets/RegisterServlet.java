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

        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email    = req.getParameter("email");
        String address  = req.getParameter("address");
        String phone    = req.getParameter("phonenumber");
        String role     = req.getParameter("role");

        UserDAO userDAOImpl = new UserDAOImpl();

        
        User existingUser = userDAOImpl.getUserByEmail(email);

        if (existingUser != null) {
            
        	resp.sendRedirect("login.jsp");
            return;
        }

       
        User user = new User();
        user.setUserName(username);
        user.setPassword(password); 
        user.setEmail(email);
        user.setAddress(address);
        user.setPhoneNumber(phone);
        user.setRole(role);

        
        userDAOImpl.addUser(user);

       
        resp.sendRedirect("login.jsp");
    }
}
