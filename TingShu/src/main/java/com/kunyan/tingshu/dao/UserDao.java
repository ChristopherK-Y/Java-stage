package com.kunyan.tingshu.dao;

import com.kunyan.tingshu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserDao {
    @Autowired
    private DataSource dataSource;

    public boolean login(User user) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT uid,nickname FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (!rs.next()) {
                        // 一条信息都没有，说明登录失败
                        //resp.sendRedirect("/login.html");
                        return false;
                    } else {
                        user.setUid(rs.getInt("uid"));
                        user.setNickname(rs.getString("nickname"));
                    }
                }
            }
        }
        return true;
    }

    public boolean register(User user) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            String sql = "INSERT INTO user (username, nickname, password) VALUES (?, ?, ?)";
            try (PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                s.setString(1, user.getUsername());
                s.setString(2, user.getNickname());
                s.setString(3, user.getPassword());

                s.executeUpdate();
                // 获取插入后的自增id，也就是 uid
                try (ResultSet rs = s.getGeneratedKeys()) {
                    rs.next();
                    user.setUid(rs.getInt(1));
                }
            }
        }
        return true;
    }
}
