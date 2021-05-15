package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void register(int sn, String name, String password) throws SQLException {
        userDao.insert(sn, name, password);
    }

    public User login(String name, String password) throws SQLException {
        return userDao.selectByNameAndPassword(name, password);
    }
}
