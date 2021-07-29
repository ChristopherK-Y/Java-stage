package com.kunyan.tingshu.controller.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@Log4j2
public class GetPictureController {
    @GetMapping("/getPicture/{picture}")
    public void getPicture(@PathVariable("picture") String picture, HttpServletResponse response) throws IOException {
        FileInputStream inputStream = new FileInputStream("/home/ultraman/tinshu/img/" + picture);
        byte[] bytes = readInputStream(inputStream);
        OutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpg");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    private static byte[] readInputStream(InputStream ins) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = ins.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        ins.close();
        return out.toByteArray();
    }

}
