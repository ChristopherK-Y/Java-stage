import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ajax-Version")
public class AjaxVersion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setStatus(200);
        resp.setContentType("text/plain");
        String[] fromData = req.getReader().readLine().split(":");
        int base = 10;
        switch (fromData[1]) {
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
        try{
            int number = Integer.parseInt(fromData[0], base);

            String ans = Integer.toString(number, 2) + "\n" +
                    Integer.toString(number, 8) + "\n" +
                    number + "\n" +
                    Integer.toString(number, 16);
            resp.getWriter().print(ans);
        }catch (NumberFormatException e){
            String ans = "输入数字与进制不匹配\n输入数字与进制不匹配\n输入数字与进制不匹配\n输入数字与进制不匹配";
            resp.getWriter().print(ans);
        }



    }
}
