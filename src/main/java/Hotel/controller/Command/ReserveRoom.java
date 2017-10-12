package Hotel.controller.Command;

import Hotel.factory.ServiceFactory;
import Hotel.model.Reservation;
import Hotel.model.Room;
import Hotel.model.User;
import Hotel.services.ReservationService;
import Hotel.services.RoomService;
import Hotel.services.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by lerafatova on 28.04.17.
 */
public class ReserveRoom implements Command {
    ReservationService reservationService = ServiceFactory.getInstance().getReservationService();
    RoomService roomService = ServiceFactory.getInstance().getRoomService();
    UserService userService = ServiceFactory.getInstance().getUserService();

    private static final Logger LOGGER = Logger.getLogger(ReserveRoom.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userPhone = request.getParameter("phone");
        int roomId = Integer.parseInt(request.getParameter("idRoom"));
        Date dateIn = Date.valueOf(request.getParameter("dateIn"));
        Date dateOut = Date.valueOf(request.getParameter("dateOut"));
        LOGGER.debug("dateIn " + dateIn + " dateOut: " + dateOut);

        User user = null;
        if (userService.userIsExistsByPhone(userPhone)){
            user = userService.getUserByPhone(userPhone);
        }else{
            user = new User(userName, userPhone);
            int id = userService.create(user);
            user.setId(id);
        }
        Room room = roomService.findById(roomId);
        boolean isFree = roomService.isFree(roomId, dateIn, dateOut);
        LOGGER.debug("isFree: " + isFree);
        LOGGER.debug("user.getId(): " + user.getId());
        if (isFree && user.getId() != 0){
            int id = reservationService.create(new Reservation(user, room, dateIn, dateOut));
            LOGGER.debug("id: " + id);
            if (id != 0) request.setAttribute("message", "success");
        }else {
        request.setAttribute("message", "unSuccess");}

        LOGGER.debug("after attribute");
        request.getRequestDispatcher("/pages/reservation.jsp").forward(request, response);
    }
}
