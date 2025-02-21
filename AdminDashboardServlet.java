package com.example.controllers;

import com.example.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null || !"Admin".equals(user.getRole())) {
            response.sendRedirect("login.html"); // Redirect if not an admin
            return;
        }

        request.setAttribute("username", user.getUsername());
        request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
    }
}
