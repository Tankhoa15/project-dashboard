package com.ntkhoa.dashboard.Controller;

import com.ntkhoa.dashboard.DAO.User;
import com.ntkhoa.dashboard.DAO.UserDAO;
import com.ntkhoa.dashboard.DAO.impl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);

        userDAO.add(user);

        request.setAttribute("status", "User added successfully");
        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }

}
