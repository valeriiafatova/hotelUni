package Hotel.controller.Command;

import Hotel.factory.CommandFactory;
import Hotel.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lerafatova on 15.04.17.
 */
public class PostResolver implements Command {
    private static final Logger LOGGER = Logger.getLogger(PostResolver.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        String command = request.getParameter("Submit");

        LOGGER.debug(command);

        if (command == null) {
            response.sendRedirect("/pages/502.html");
            return;
        }
        Pattern p = Pattern.compile("[a-zA-Z|_]+");
        Matcher m = p.matcher(command);

        if (!m.matches()) {
            response.sendRedirect("/pages/502.html");
            return;
        }

        commandFactory.getCommand(command).execute(request, response);
    }


}
