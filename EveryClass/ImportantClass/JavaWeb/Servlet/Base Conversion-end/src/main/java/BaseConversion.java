import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transform")
public class BaseConversion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        TemplateEngine engine = (TemplateEngine) servletContext.getAttribute("Base_Conversion_engine");
        WebContext webContext = new WebContext(req, resp, servletContext);

        String sel = req.getParameter("sel");
        String number = req.getParameter("number");

        if(sel != null && number != null){
            String[] all = returnAns(sel, number).split(" ");
            webContext.setVariable("out2", all[0]);
            webContext.setVariable("out8", all[1]);
            webContext.setVariable("out10", all[2]);
            webContext.setVariable("out16", all[3]);
        }

        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        engine.process("Base_Conversion", webContext, writer);
    }

    private String returnAns(String sel, String number) {
        int base = 0;
        switch (sel) {
            case "base2":
                base = 2;
                break;
            case "base8":
                base = 8;
                break;
            case "base10":
                base = 10;
                break;
            case "base16":
                base = 16;
                break;
        }
        int base10Number = Integer.parseInt(number, base);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(base10Number, 2)).append(" ");
        sb.append(Integer.toString(base10Number, 8)).append(" ");
        sb.append(base10Number).append(" ");
        sb.append(Integer.toString(base10Number, 16));
        return sb.toString();
    }
}
