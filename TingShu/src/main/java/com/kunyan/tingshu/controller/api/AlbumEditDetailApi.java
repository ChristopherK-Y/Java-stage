package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.model.Album;
import com.kunyan.tingshu.model.User;
import com.kunyan.tingshu.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class AlbumEditDetailApi implements AbsApiController {
    @Autowired
    private AlbumService albumService;


    @GetMapping("/api/edit-album-detail.json")
    @Override
    public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doGet(req, resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            throw new ApiException(401, "必须登陆后才能使用");
        }

        String aid = req.getParameter("aid");
        if (aid == null || aid.trim().isEmpty()) {
            throw new ApiException(400, "参数 aid 是必须的");
        }

        int intAid = Integer.parseInt(aid);
        Album album = albumService.detail(intAid);
        if(album == null){
            throw new ApiException(500,"aid错误");
        }

        if (!album.getUid().equals(currentUser.getUid())) {
            throw new ApiException(403, "只有专辑作者才可以访问");
        }
        return album;
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }
}
