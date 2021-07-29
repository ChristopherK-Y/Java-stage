package com.kunyan.tingshu.service;

import com.kunyan.tingshu.dao.AlbumDao;
import com.kunyan.tingshu.dao.StoryDao;
import com.kunyan.tingshu.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private StoryDao storyDao;

    public List<Album> listUsingKeyWord(String keyword) throws SQLException {
        return albumDao.selectListLikeName(keyword);
    }

    public Album detail(int aid) throws SQLException {
        Album album = albumDao.selectOneUsingAid(aid);
        if (album == null) {
            return null;
        }

        album.storyList = storyDao.selectListUsingAid(aid);
        return album;
    }

    public int save(int uid, String name, String brief, String cover, String header) throws SQLException {
        return albumDao.insert(uid, name, brief, cover, header);
    }

    public List<Album> listUsingUid(int uid) throws SQLException {
        return albumDao.selectListUsingUid(uid);
    }
}
