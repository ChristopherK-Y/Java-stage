package com.kunyan.tingshu.controller.api;

import com.kunyan.tingshu.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class CurrentUserApi {
    @GetMapping("/api/current-user.json")
    public Object currentUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        Object result;

        if (currentUser == null) {
            result = new Object() {
                public final boolean logged = false;
            };
        } else {
            result = new Object() {
                public final boolean logged = true;
                public final User user = currentUser;
            };
        }
        return result;
    }
}
