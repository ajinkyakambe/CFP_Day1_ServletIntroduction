
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/* UC2
Create a simple Login
with predefined user
 */
@WebServlet(
        description="Login Servlet Testing",
        urlPatterns={"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user",value = "ajinkya"),
                @WebInitParam(name = "password",value = "kambe")
                }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user= request.getParameter("user");
        String pwd= request.getParameter("pwd");

        String userId = getServletConfig().getInitParameter("user");
        String password= getServletConfig().getInitParameter("password");

        if (userId.equals(user) && password.equals(pwd)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<p> Either user name and password is wrong.</p>");
            rd.include(request,response);
        }
    }
}