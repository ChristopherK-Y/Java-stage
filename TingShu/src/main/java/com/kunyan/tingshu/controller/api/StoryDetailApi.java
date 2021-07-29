package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.model.Story;
import com.kunyan.tingshu.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class StoryDetailApi implements AbsApiController {
    @Autowired
    private StoryService storyService;

    @GetMapping("/api/story-detail.json")
    @Override
    public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doGet(req, resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException {
        String sid = req.getParameter("sid");
        if (sid == null || sid.trim().isEmpty()) {
            throw new ApiException(400, "参数 sid 是必须的");
        }

        int intSid = Integer.parseInt(sid);
        Story story = storyService.detail(intSid);
        if (story == null) {
            throw new ApiException(404, "sid 对应的故事不存在");
        }
        return story;
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }
}
