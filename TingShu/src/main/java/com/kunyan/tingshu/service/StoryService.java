package com.kunyan.tingshu.service;

import com.kunyan.tingshu.dao.StoryDao;
import com.kunyan.tingshu.model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.SQLException;

@Service
public class StoryService {
    @Autowired
    private StoryDao storyDao;

    public Story detail(int sid) throws SQLException {
        return storyDao.selectOneUsingSid(sid);
    }

    public InputStream voice(int sid) throws SQLException {
        return storyDao.selectOneAudioColumnUsingSid(sid);
    }

    public void sava(int aid, String name, InputStream audio) throws SQLException {
        storyDao.insert(aid, name, audio);
    }

    public int getAidUsingSid(int sid) throws SQLException {
        Story story = storyDao.selectOneUsingSid(sid);
        if (story == null) {
            return -1;
        }
        return story.getAid();
    }

    public void increaseCount(int aid, int sid) throws SQLException {
        storyDao.increaseCount(aid, sid);
    }
}
