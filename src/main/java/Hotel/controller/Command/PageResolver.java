package Hotel.controller.Command;

import Hotel.factory.CommandFactory;
import Hotel.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by lerafatova on 15.04.17.
 */
public class PageResolver implements Command {
    private static final Logger LOGGER = Logger.getLogger(PageResolver.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        String requestURI = request.getRequestURI();

        LOGGER.debug("requestURI: " + requestURI);
        if ("/".equals(requestURI) || "/main/home/".equals(requestURI) || "/main/".equals(requestURI)) {
            LOGGER.debug("redirect /home/");
            request.getRequestDispatcher("/main/home").forward(request, response);
            return;
        }

        LOGGER.debug("after if");
        int index = requestURI.lastIndexOf('/');
        String command = requestURI.substring(index + 1);
        LOGGER.debug("command: " + command);

        commandFactory.getCommand(command).execute(request, response);
    }
}
