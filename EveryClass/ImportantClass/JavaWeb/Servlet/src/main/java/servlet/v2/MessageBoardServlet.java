package servlet.v2;

import model.Message;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/v2/message-board")
public class MessageBoardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getQueryString());
        // 设置的是 request 的字符集编码
        req.setCharacterEncoding("utf-8");

        // 读取用户输入过来的参数
        // parameter: 参数
        // 当返回值是 null 时，用户没有提交这个参数
        // getParameter 可以接受 GET / POST 表单提交过来的数据
        String who = req.getParameter("who");
        String target = req.getParameter("target");
        String what = req.getParameter("what");
        System.out.println("who: " + who);
        System.out.println("target: " + target);
        System.out.println("what: " + what);

        if (who != null && target != null && what != null) {
            // 保存 Message
            try (Connection c = DBUtil.connection()) {
                String sql = "INSERT INTO messages (who, target, what) VALUES (?, ?, ?)";
                try (PreparedStatement s = c.prepareStatement(sql)) {
                    s.setString(1, who);
                    s.setString(2, target);
                    s.setString(3, what);

                    s.executeUpdate();
                }
            } catch (SQLException exc) {
                throw new ServletException(exc);
            }
        }

        output(resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        output(resp);
    }

    private void output(HttpServletResponse resp) throws IOException, ServletException {
        String html1 = "<!DOCTYPE html>\n" +
                "<html lang=\"zh-hans\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>留言板</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <form method=\"post\" action=\"/v2/message-board\">\n" +
                "    <label for=\"who\">谁</label><input type=\"text\" id=\"who\" name=\"who\">\n" +
                "    <label for=\"target\">向谁</label><input type=\"text\" id=\"target\" name=\"target\">\n" +
                "    <label for=\"what\">说什么</label><input type=\"text\" id=\"what\" name=\"what\">\n" +
                "    <button type=\"submit\">提交</button>\n" +
                "  </form>\n" +
                "\n" +
                "  <table>\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>谁</th>\n" +
                "        <th>向谁</th>\n" +
                "        <th>说什么</th>\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>";
        String html2 = "</tbody>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>";

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(html1);

        List<Message> messageList = null;
        try {
            messageList = queryMessageList();
        } catch (SQLException exc) {
            throw new ServletException(exc);
        }
        for (Message message : messageList) {
            writer.printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", message.who, message.target, message.what);
        }
        writer.print(html2);
    }

    private List<Message> queryMessageList() throws SQLException {

        List<Message> list = new ArrayList<>();
        try (Connection c = DBUtil.connection()) {
            String sql = "SELECT who, target, what FROM messages ORDER BY id DESC";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        String who = rs.getString("who");
                        String target = rs.getString("target");
                        String what = rs.getString("what");

                        Message message = new Message();
                        message.who = who;
                        message.target = target;
                        message.what = what;

                        list.add(message);
                    }
                }
            }
        }

        return list;
    }
}
