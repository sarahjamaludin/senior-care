package com.example.controllers;

import com.example.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Mock database check
        User user = null;
        if ("admin".equals(username) && "admin123".equals(password)) {
            user = new User(username, password, "Admin");
        } else if ("user".equals(username) && "user123".equals(password)) {
            user = new User(username, password, "User");
        }

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("login.html?error=Invalid credentials");
        }
    }
}
