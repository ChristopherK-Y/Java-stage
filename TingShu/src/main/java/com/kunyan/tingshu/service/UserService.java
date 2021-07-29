package com.kunyan.tingshu.service;

import com.kunyan.tingshu.dao.UserDao;
import com.kunyan.tingshu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean login(User user) throws SQLException {
        return userDao.login(user);
    }

    public boolean register(User user) throws SQLException {
        return userDao.register(user);
    }
}
