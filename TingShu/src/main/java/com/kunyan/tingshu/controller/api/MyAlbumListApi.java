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
import java.util.List;

@RestController
public class MyAlbumListApi implements AbsApiController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/api/my-album-list.json")
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

        Integer uid = currentUser.getUid();
        return albumService.listUsingUid(uid);
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }
}
