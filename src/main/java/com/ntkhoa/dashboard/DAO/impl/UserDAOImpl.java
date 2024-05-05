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
    public boolean login(String email, String password) {
        boolean isLoggedIn = false;
        try {
            String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        isLoggedIn = (count > 0);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLoggedIn;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
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
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setLong(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE users SET full_name = ?, email = ?, password = ? WHERE id = ?");
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setLong(4, user.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * from User WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}
