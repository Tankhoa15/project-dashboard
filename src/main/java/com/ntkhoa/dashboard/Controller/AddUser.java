package com.ntkhoa.dashboard.Controller;

import com.ntkhoa.dashboard.DAO.UserDAO;
import com.ntkhoa.dashboard.DAO.impl.UserDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {

    UserDAO userDAO = new UserDAOImpl();


}
