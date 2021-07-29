package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.model.Album;
import com.kunyan.tingshu.model.User;
import com.kunyan.tingshu.service.AlbumService;
import com.kunyan.tingshu.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class NewStoryApi implements AbsApiController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private StoryService storyService;

    @PostMapping("/api/new-story.json")
    @Override
    public Object doPost(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doPost(req,resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException, ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            throw new ApiException(401, "必须先登陆");
        }

        String name = req.getParameter("name");
        int aid = Integer.parseInt(req.getParameter("aid"));
        Part audio = req.getPart("audio");

        Album album = albumService.detail(aid);
        if (album == null) {
            throw new ApiException(404, "对应的专辑不存在");
        }

        if (!album.getUid().equals(currentUser.getUid())) {
            throw new ApiException(403, "只有该专辑的作者才有添加故事的权限");
        }

        storyService.sava(aid, name, audio.getInputStream());
        return null;
    }
}
