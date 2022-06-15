
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
                @WebInitParam(name = "password",value = "kambe@2007")
                }
)

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request parameters for user ID and password
        String user= request.getParameter("user");
        String pwd= request.getParameter("pwd");
        // get servlet config init params
        String userId = getServletConfig().getInitParameter("user");
        String password= getServletConfig().getInitParameter("password");

        /* UC3:
        Extend the Servlet to accept a valid Name
        - Name starts with Cap and has minimum 3 characters
         */

        String nameValidate = "^[A-Z][a-z]{5}";

        /*UC 4
        Extend the Servlet to accept a valid Password
        - Rule1 – minimum 8 Characters
        - Rule2 – Should have at least 1 Upper Case
        - Rule3 – Should have at least 1 numeric number in the password
        - Rule4 – Has exactly 1 Special Character
         */
        String passwordValidate = "^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$";


        if(userId.equals(user) && userId.matches(nameValidate) && password.equals(pwd) && password.matches(passwordValidate)) {
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