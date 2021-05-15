package servlet;

import model.Book;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import service.BookService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class BookListServlet extends HttpServlet {
    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String keyword = req.getParameter("keyword");

        try {
            List<Book> bookList = bookService.search(keyword);

            ServletContext servletContext = req.getServletContext();
            WebContext context = new WebContext(req, resp, servletContext);
            context.setVariable("bookList", bookList);

            TemplateEngine engine = (TemplateEngine) servletContext.getAttribute("engine");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            engine.process("book-list", context, resp.getWriter());
        } catch (SQLException exc) {
            throw new ServletException(exc);
        }
    }
}
