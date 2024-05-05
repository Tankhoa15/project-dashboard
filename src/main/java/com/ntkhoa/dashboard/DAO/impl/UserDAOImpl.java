package com.ntkhoa.dashboard.DAO.impl;

import com.ntkhoa.dashboard.DAO.User;
import com.ntkhoa.dashboard.DAO.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            connect();
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            if(rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFullName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public Long add(User user) {
        try {
            connect();
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)");
            stmt.setString(1,user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                disconnect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User findByEmail() {
        return null;
    }
}
