package dao;

import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void insert(Integer sn, String name, String password) throws SQLException {
        String sql = "INSERT INTO students (sn, name, password) VALUES (?, ?, ?)";
        try (Connection c = DBUtil.connection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, sn);
                s.setString(2, name);
                s.setString(3, password);

                s.executeUpdate();
            }
        }
    }

    public User selectByNameAndPassword(String name, String password) throws SQLException {
        String sql = "SELECT sid, sn, name FROM students WHERE name = ? AND password = ?";
        try (Connection c = DBUtil.connection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setString(1, name);
                s.setString(2, password);

                try (ResultSet rs = s.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }

                    User user = new User();
                    user.sid = rs.getInt("sid");
                    user.sn = rs.getInt("sn");
                    user.name = rs.getString("name");

                    return user;
                }
            }
        }
    }
}
