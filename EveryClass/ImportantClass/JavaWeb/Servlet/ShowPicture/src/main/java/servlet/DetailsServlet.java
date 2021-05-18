package servlet;

import model.Figure;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import service.QueryService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    private final QueryService service = new QueryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        WebContext webContext = new WebContext(req, resp, servletContext);

        String id = req.getParameter("id");
        try {
            Figure query = service.query(Integer.parseInt(id));
            webContext.setVariable("imgHref", query.imgHref);
            webContext.setVariable("mainDescription", query.mainDescription);
            webContext.setVariable("secondaryDescription", query.secondaryDescription);

            TemplateEngine engine = (TemplateEngine) servletContext.getAttribute("engine");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            engine.process("details", webContext, resp.getWriter());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
