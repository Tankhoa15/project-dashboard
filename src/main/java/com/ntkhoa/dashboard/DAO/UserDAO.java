package com.ntkhoa.dashboard.DAO;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    Long add(User user);
    boolean delete(Long id);
    boolean update(User user);
    User findByEmail();
}
