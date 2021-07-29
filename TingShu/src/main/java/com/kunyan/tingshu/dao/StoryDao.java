package com.kunyan.tingshu.dao;

import com.kunyan.tingshu.model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StoryDao {
    @Autowired
    private DataSource dataSource;

    public Story selectOneUsingSid(int sid) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            String sql = "SELECT aid, name, created_at, count FROM story WHERE sid = ?";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, sid);

                try (ResultSet rs = s.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }

                    Story story = new Story();
                    story.setSid(sid);
                    story.setAid(rs.getInt("aid"));
                    story.setName(rs.getString("name"));
                    story.setCreatedAt(rs.getDate("created_at"));
                    story.setCount(rs.getInt("count"));
                    return story;
                }
            }
        }
    }

    public List<Story> selectListUsingAid(int aid) throws SQLException {
        List<Story> storyList = new ArrayList<>();
        try (Connection c = dataSource.getConnection()) {
            String sql = "SELECT sid, name, created_at, count FROM story WHERE aid = ? ORDER BY sid ASC";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, aid);
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        Story story = new Story();
                        story.setSid(rs.getInt("sid"));
                        story.setName(rs.getString("name"));
                        story.setCreatedAt(rs.getDate("created_at"));
                        story.setCount(rs.getInt("count"));

                        storyList.add(story);
                    }
                }
            }
        }
        return storyList;
    }

    public InputStream selectOneAudioColumnUsingSid(int sid) throws SQLException {
        try (Connection c = dataSource.getConnection()) {
            String sql = "SELECT audio FROM story WHERE sid = ?";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, sid);
                try (ResultSet rs = s.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }

                    return rs.getBinaryStream("audio");
                }
            }
        }
    }

    public void insert(int aid, String name, InputStream audio) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO story (aid,name,audio) VALUES (?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, aid);
                preparedStatement.setString(2, name);
                preparedStatement.setBlob(3, audio);

                preparedStatement.executeUpdate();
            }
        }
    }

    public void increaseCount(int aid,int sid) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);

            String sql1 = "UPDATE story SET count = count + 1 WHERE sid = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
                preparedStatement.setInt(1,sid);

                preparedStatement.executeUpdate();
            }

            String sql2 = "UPDATE album SET count = count + 1 WHERE aid = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql2)) {
                preparedStatement.setInt(1,aid);

                preparedStatement.executeUpdate();
            }

            connection.commit();
        }
    }
}
