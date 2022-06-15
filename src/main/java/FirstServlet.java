
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
UC1: Create FirstServlet Class
 */

@WebServlet("/FirstServlet")
public class  FirstServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!! Ajinkya's First Servlet!!</h3>");
        out.close();
    }
}

// httpServer.createContext("/echoGet", (HttpHandler) new Handler.EchoGetHandler());
