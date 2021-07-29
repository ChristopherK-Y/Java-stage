package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class StoryPlayedApi implements AbsApiController {
    @Autowired
    private StoryService storyService;

    @GetMapping("/api/story-played.json")
    @Override
    public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doGet(req, resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException, ServletException, IOException {
        String sid = req.getParameter("sid");
        if (sid == null || sid.trim().isEmpty()) {
            throw new ApiException(400, "参数 sid 是必须的");
        }
        int sidInt = Integer.parseInt(sid);
        int aid = storyService.getAidUsingSid(sidInt);

        if (aid == -1) {
            throw new ApiException(404, "该故事不存在");
        }

        storyService.increaseCount(aid, sidInt);

        return null;
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException, ServletException, IOException {
        return null;
    }
}
