package com.kunyan.tingshu.controller.api;


import com.kunyan.tingshu.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class AlbumListApi implements AbsApiController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/api/album-list.json")
    @Override
    public Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        return AbsApiController.super.doGet(req, resp);
    }

    @Override
    public Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException {
        String keyword = req.getParameter("keyword");
        if (keyword != null && keyword.trim().isEmpty()) {
            keyword = null;
        }
        return albumService.listUsingKeyWord(keyword);
    }

    @Override
    public Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException {
        return null;
    }
}
