package MessageAPI;

import UserAPI.User;
import UserAPI.UserManagement;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

/**
* @author Leon Rosamilia
* @implNote accept get and post but get return error, post uses number code to choose the action
 */
public class MessageAPI extends HttpServlet{
    /**
     * @author Leon Rosamilia
     * @param request the http request
     * @param response the http response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    /**
     * @author Leon Rosamilia
     * @param request the http request
     * @param response the http response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("op");
        String password, email, name, surname;
        User user;
        switch (operation) {
            case "":
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
            case "0":
                email = request.getParameter("email");
                password = request.getParameter("password");
                break;
            case "1":
                email = request.getParameter("email");
                password = request.getParameter("password");
                surname = request.getParameter("surname");
                name = request.getParameter("name");
                user = new User(email,name,surname,password);
                try {
                    UserManagement.create(user);
                } catch (Exception e) {
                    response.setContentType("text/plain");
                    response.getWriter().write("User already exists");
                    response.getWriter().close();
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
