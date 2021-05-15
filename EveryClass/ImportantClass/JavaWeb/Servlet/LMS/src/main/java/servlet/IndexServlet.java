package servlet;

import model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        WebContext context = new WebContext(req, resp, servletContext);
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        context.setVariable("user", user);

        TemplateEngine engine = (TemplateEngine)servletContext.getAttribute("engine");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        engine.process("index", context, resp.getWriter());
    }
}
