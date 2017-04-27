package Hotel.controller.Command;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lerafatova on 15.04.17.
 */
public class NotFound implements Command {
    private static final Logger LOGGER = Logger.getLogger(NotFound.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/404.html").forward(request, response);
    }
}
