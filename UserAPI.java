import Util.Generator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import UserAPI.*;

public class UserAPI {
    // DB: 192.168.56.101:3306
    /**
     * @author Leon Rosamilia
     * @param request the http request
     * @param response the http response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException
    {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    /**
     * @author Leon Rosamilia
     * @param request the http request
     * @param response the http response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("op");
        String password, email, name, surname;
        User user;
        // 0 login
        // 1 create user
        // 2 get user
        switch (operation) {
            case "0":
                email = request.getParameter("email");
                password = request.getParameter("password");
                user = new User(email,password);
                try {
                    Cookie ck=new Cookie("session_id", String.valueOf(Generator.sessionId()));
                    UserManagement.login(user,Integer.parseInt(ck.getValue()));
                    response.addCookie(ck);
                } catch (SQLException se) {
                    response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                }
                break;
            case "1":
                email = request.getParameter("email");
                password = request.getParameter("password");
                surname = request.getParameter("surname");
                name = request.getParameter("name");
                user = new User(email,name,surname,password);
                try {
                    UserManagement.create(user);
                } catch (SQLException e) {
                    response.setContentType("text/plain");
                    response.getWriter().write("User already exists");
                    response.getWriter().close();
                } catch (Exception ex){
                    response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                }
                break;
            case "2":
                try {
                    Cookie[] cook = request.getCookies();
                    user = UserManagement.getUser(Integer.parseInt(cook[0].getValue()));
                } catch (SQLException se) {
                    response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}
