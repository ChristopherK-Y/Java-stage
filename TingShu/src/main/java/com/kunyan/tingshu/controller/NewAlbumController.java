package com.kunyan.tingshu.controller;

import com.kunyan.tingshu.model.User;
import com.kunyan.tingshu.service.AlbumService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

//@MultipartConfig
@Log4j2
@Controller
public class NewAlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping("/new-album")
    public void newAlbum(@RequestParam String name, @RequestParam String brief,
                         @RequestPart MultipartFile cover, @RequestPart MultipartFile header,
                         HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            resp.sendError(401, "必须先登陆");
            return;
        }

        String coverPath = saveImage(cover);
        String headerPath = saveImage(header);
        if (coverPath == null || headerPath == null) {
            resp.sendError(400, "上传文件类型错误");
            return;
        }
        int aid = albumService.save(currentUser.getUid(), name, brief, coverPath, headerPath);
        resp.sendRedirect("/album-editor.html?aid=" + aid);
    }

    private String saveImage(MultipartFile file) throws IOException {
        // 把图片保存成文件，保存在 target/...-1.0-SNAPSHOT/img/
        // 保存在这里，图片可以理解被访问
        // 缺点：一旦删除了 target，这些图片就全部 404 了


        // 图片名称，使用 UUID，保证不重复，图片后缀，使用 submittedFilename 中的后缀
        // 理论上有安全问题
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return null;
        }
        int i = originalFilename.lastIndexOf('.');
        String extension = originalFilename.substring(i);
        String uuid = UUID.randomUUID().toString();
        String pictureName = uuid + extension;
        String filename = "/img/" + pictureName;

        //String realPath = ResourceUtils.getURL("classpath:").getPath() + "static" + filename;
        String realPath = "/home/ultraman/tinshu" + filename;
        log.debug("路径为:" + realPath);
        File fileToWrite = new File(realPath);
        file.transferTo(fileToWrite);

        return pictureName;
    }
}
