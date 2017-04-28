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
        String requestURI = request.getRequestURI();
        int index = requestURI.lastIndexOf('/');
        String page = requestURI.substring(index + 1);
        if(page.equals("reservInfo")){
            request.setAttribute("idRoom",request.getParameter("idRoom"));
        }
        request.getRequestDispatcher("/pages/" + page + ".jsp").forward(request, response);
    }
}
