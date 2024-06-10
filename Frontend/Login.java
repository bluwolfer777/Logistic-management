package Frontend;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    // DB: 192.168.56.101:3306
    /**
     * @author Leon Rosamilia
     * @param request the http request
     * @param response the http response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException
    {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
    }
}
