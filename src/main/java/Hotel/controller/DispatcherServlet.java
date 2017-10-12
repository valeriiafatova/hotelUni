package Hotel.controller;

import Hotel.factory.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class DispatcherServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(DispatcherServlet.class);

    private CommandFactory commandFactory = CommandFactory.getInstance();

    String errorURI = "/pages/502.html";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            LOGGER.error("to pageResolver");
            pageResolver(request, response);
        } catch (Exception e) {
            LOGGER.error("Exception: " + e.getMessage());
            badRequest(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("Submit");
        LOGGER.debug("command " + command);

        try {
            postResolver(request, response);
        } catch (Exception e) {
            LOGGER.error(" " + e.toString());
            badRequest(request, response);
        }
    }

    private void pageResolver(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandFactory.getPageResolver().execute(req, resp);
    }

    private void postResolver(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandFactory.getPostResolver().execute(req, resp);
    }

    private void badRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(errorURI).forward(request, response);
    }

}
