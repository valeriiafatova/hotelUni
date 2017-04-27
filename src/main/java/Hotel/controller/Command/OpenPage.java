package Hotel.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lerafatova on 28.04.17.
 */
public class OpenPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getParameter("page");
        request.getRequestDispatcher("/" + uri).forward(request, response);
    }
}
