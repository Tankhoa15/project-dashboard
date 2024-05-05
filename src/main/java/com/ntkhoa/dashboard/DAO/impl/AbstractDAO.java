package com.ntkhoa.dashboard.DAO.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/dashboard";

    protected Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root", "123456789");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    protected void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
