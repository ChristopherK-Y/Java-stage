package com.kunyan.tingshu.controller;

import com.kunyan.tingshu.model.User;
import com.kunyan.tingshu.service.UserService;
import com.kunyan.tingshu.util.SHA512;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(User user, HttpServletRequest req, HttpServletResponse resp) throws SQLException, NoSuchAlgorithmException, IOException {
        String sha512Password = SHA512.sha512(user.getPassword());
        user.setPassword(sha512Password);

        boolean loginSituation = userService.login(user);
        if (loginSituation) {//登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            // 执行重定向
            resp.sendRedirect("/");
        } else {//登录失败
            resp.sendRedirect("/login.html");
        }
    }

    @PostMapping("/register")
    public void register(User user, HttpServletRequest req, HttpServletResponse resp) throws NoSuchAlgorithmException, SQLException, IOException {
        // 数据库中不保存明文密码，把密码利用 SHA-512 算法做 hash —— 目前的方法也不是最好的
        user.setPassword(SHA512.sha512(user.getPassword()));
        // 进行用户注册 —— 插入数据库表
        boolean registerSituation = userService.register(user);
        // 设定用户登录 ： 把当前登录的用户信息写入 session 中
        if (registerSituation) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            // 执行重定向
            resp.sendRedirect("/");
        } else {
            //TODO:注册失败
            //用户名重复(UNQ)
        }
    }
}
