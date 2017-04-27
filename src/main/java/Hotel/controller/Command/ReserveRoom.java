package Hotel.controller.Command;

import Hotel.factory.ServiceFactory;
import Hotel.services.ReservationService;
import Hotel.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lerafatova on 28.04.17.
 */
public class ReserveRoom implements Command{
    ReservationService reservationService = ServiceFactory.getInstance().getReservationService();
    UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        int roomId = Integer.parseInt(request.getParameter("roomId"));
    }
}
