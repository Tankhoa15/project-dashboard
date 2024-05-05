package com.ntkhoa.dashboard.DAO.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    private Connection connection;

    protected void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dashboard", "root", "123456789");
    }

    protected Connection getConnection() {
        return connection;
    }

    protected void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
