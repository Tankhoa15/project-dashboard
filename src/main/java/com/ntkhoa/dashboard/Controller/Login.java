package com.ntkhoa.dashboard.Controller;

import com.ntkhoa.dashboard.DAO.UserDAO;
import com.ntkhoa.dashboard.DAO.impl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        request.getRequestDispatcher("/userManager.jsp").forward(request,response);
        if(!userDAO.login(email,password)){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
