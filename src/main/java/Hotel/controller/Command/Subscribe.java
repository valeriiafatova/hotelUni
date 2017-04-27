package Hotel.controller.Command;

import Hotel.factory.ServiceFactory;
import Hotel.model.Subscriber;
import Hotel.services.SubscriberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class Subscribe implements Command {
    SubscriberService subscriberService = ServiceFactory.getInstance().getSubscriberService();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (name == null || email == null) {
            response.sendRedirect("/pages/502.html");
            return;
        }

        int result = subscriberService.create(new Subscriber(name, email));
        if (result != 0){
            request.setAttribute("message", "You subscribed");
        }else {
            request.setAttribute("message", "Something wrong");
        }
    }
}
