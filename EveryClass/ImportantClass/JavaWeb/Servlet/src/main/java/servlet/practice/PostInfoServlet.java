package servlet.practice;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/practice/post-info")
public class PostInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 不做参数有效检查了
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");
        String xueli = req.getParameter("xueli");
        String suggestion = req.getParameter("suggestion");

        String hobby = String.join(":", hobbies);

        System.out.println(name);
        System.out.println(gender);
        System.out.println(hobby);
        System.out.println(xueli);
        System.out.println(suggestion);

        try (Connection c = DBUtil.connection()) {
            String sql = "INSERT INTO informations (name, gender, hobby, xueli, suggestion) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setString(1, name);
                s.setString(2, gender);
                s.setString(3, hobby);
                s.setString(4, xueli);
                s.setString(5, suggestion);

                s.executeUpdate();
            }
        } catch (SQLException exc) {
            throw new ServletException(exc);
        }

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.print("<h1>谢谢提交</h1>");
    }
}
