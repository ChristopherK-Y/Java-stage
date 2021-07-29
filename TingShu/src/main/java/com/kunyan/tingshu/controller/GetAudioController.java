package com.kunyan.tingshu.controller;

import com.kunyan.tingshu.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@Controller
public class GetAudioController {
    @Autowired
    private StoryService storyService;

    @GetMapping("/get-audio")
    public void getAudio(@RequestParam(value = "sid") String sid, HttpServletResponse resp) throws IOException, SQLException {
        if (sid == null || sid.trim().isEmpty()) {
            resp.sendError(400, "参数 sid 是必须的");
            return;
        }

        int intSid = Integer.parseInt(sid);
        resp.setContentType("audio/ogg; codecs=opus");
        InputStream voice = storyService.voice(intSid);

        if (voice == null) {
            resp.sendError(404, "sid 对应的声音不存在");
            return;
        }

        byte[] buf = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while (true) {
            int len = voice.read(buf);
            if (len == -1) {
                break;
            }
            outputStream.write(buf, 0, len);
        }
        outputStream.flush();
        voice.close();
    }
}
