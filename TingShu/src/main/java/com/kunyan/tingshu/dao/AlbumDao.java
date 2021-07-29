package com.kunyan.tingshu.dao;

import com.kunyan.tingshu.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumDao {
    @Autowired
    private DataSource dataSource;

    public List<Album> selectListLikeName(String keyword) throws SQLException {
        String sql;
        if (keyword != null) {
            sql = "SELECT aid, name, cover, count FROM album WHERE name LIKE ? ORDER BY aid DESC LIMIT 20";
        } else {
            sql = "SELECT aid, name, cover, count FROM album ORDER BY aid DESC LIMIT 20";
        }
        try (Connection c = dataSource.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                if (keyword != null) {
                    // SQL: WHERE name LIKE %hello%: 只要名字中有 hello 就匹配
                    s.setString(1, "%" + keyword + "%");
                }
                List<Album> albumList = new ArrayList<>();
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        Album album = new Album();
                        album.setAid(rs.getInt("aid"));
                        album.setName(rs.getString("name"));
                        album.setCover(rs.getString("cover"));
                        album.setCount(rs.getInt("count"));

                        albumList.add(album);
                    }
                }
                return albumList;
            }
        }
    }

    public Album selectOneUsingAid(int aid) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            String sql = "SELECT uid, name, cover, header, brief, created_at, count FROM album WHERE aid = ?";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, aid);
                try (ResultSet rs = s.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }

                    Album album = new Album();
                    album.setAid(aid);
                    album.setUid(rs.getInt("uid"));
                    album.setName(rs.getString("name"));
                    album.setCover(rs.getString("cover"));
                    album.setHeader(rs.getString("header"));
                    album.setBrief(rs.getString("brief"));
                    album.setCreatedAt(rs.getDate("created_at"));
                    album.setCount(rs.getInt("count"));

                    return album;
                }
            }
        }
    }

    public int insert(int uid, String name, String brief, String cover, String header) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            String sql = "INSERT INTO album (uid, name, brief, cover, header) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                s.setInt(1, uid);
                s.setString(2, name);
                s.setString(3, brief);
                s.setString(4, cover);
                s.setString(5, header);

                s.executeUpdate();

                try (ResultSet rs = s.getGeneratedKeys()) {
                    rs.next();
                    return rs.getInt(1);
                }
            }
        }
    }

    public List<Album> selectListUsingUid(int uid) throws SQLException {
        List<Album> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT aid,name,cover,count,created_at FROM album WHERE uid = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, uid);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Album album = new Album();
                        album.setAid(rs.getInt("aid"));
                        album.setName(rs.getString("name"));
                        album.setCover(rs.getString("cover"));
                        album.setCreatedAt(rs.getDate("created_at"));
                        album.setCount(rs.getInt("count"));

                        list.add(album);
                    }
                    return list;
                }
            }
        }
    }
}
