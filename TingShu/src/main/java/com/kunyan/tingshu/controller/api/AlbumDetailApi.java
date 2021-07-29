package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.model.Album;
import com.kunyan.tingshu.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class AlbumDetailApi implements AbsApiController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/api/album-detail.json")
    @Override
    public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doGet(req, resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException {
        String aid = req.getParameter("aid");
        if (aid == null || aid.trim().isEmpty()) {
            throw new ApiException(400, "参数 aid 是必须的");
        }

        int aidInt = Integer.parseInt(aid);

        Album album = albumService.detail(aidInt);
        if (album == null) {
            throw new ApiException(404, "aid 对应的专辑不存在");
        }

        return album;
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }
}
