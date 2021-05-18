package servlet;

import model.Figure;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import service.FigureService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("")
public class IndexServlet extends HttpServlet {
    private FigureService service = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        WebContext webContext = new WebContext(req, resp, servletContext);

        try {
            List<Figure> figureList = service.getFigureList();
            webContext.setVariable("figureList", figureList);

            TemplateEngine engine = (TemplateEngine) servletContext.getAttribute("engine");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            engine.process("index", webContext, resp.getWriter());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
