package com.tap.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.model.User;
import com.tap.utility.DBconnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final int MAX_ATTEMPTS = 3;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Get remaining attempts from session
        Integer attemptsLeft = (Integer) session.getAttribute("loginAttempts");
        if (attemptsLeft == null) {
            attemptsLeft = MAX_ATTEMPTS;
        }

        // If attempts exhausted
        if (attemptsLeft <= 0) {
            req.setAttribute("loginBlocked", true);
            resp.sendRedirect("register.jsp");

            return;
        }

        User user = authenticateUser(email, password);

        if (user != null) {
            // ✅ Successful login
            session.setAttribute("user", user);
            session.removeAttribute("loginAttempts");

            resp.sendRedirect("Restaurant"); // or home page
            return;
        }

        // ❌ Invalid credentials
        attemptsLeft--;
        session.setAttribute("loginAttempts", attemptsLeft);

        req.setAttribute("errorMessage", "Invalid email or password");

        if (attemptsLeft > 0) {
            req.setAttribute("attemptsLeft", attemptsLeft);
        } else {
            req.setAttribute("loginBlocked", true);
        }

        forwardToLogin(req, resp);
    }

    // ---------------- HELPER METHODS ----------------

    private void forwardToLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }

    private User authenticateUser(String email, String password) {

        String QUERY = "SELECT * FROM user WHERE email=? AND password=?";
        User user = null;

        try (Connection con = DBconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(QUERY)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phonenumber"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
