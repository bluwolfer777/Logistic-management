package MessageAPI;

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
        switch (operation) {
            case "":
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
            case "1":
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
