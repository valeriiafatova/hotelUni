package Hotel.controller.Command;

import Hotel.enums.RoomType;
import Hotel.factory.ServiceFactory;
import Hotel.model.Room;
import Hotel.services.RoomService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lerafatova on 28.04.17.
 */
public class ShowRooms implements Command {
    private static final Logger LOGGER = Logger.getLogger(ShowRooms.class);
    RoomService roomService = ServiceFactory.getInstance().getRoomService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("");
        List<Room> list = roomService.findAll();
        LOGGER.debug("after");
        RoomType roomType = RoomType.valueOf(request.getParameter("roomType").toUpperCase());
        LOGGER.debug(roomType);

        request.setAttribute("rooms", list.stream().filter(e -> e.getRoomType() == roomType).collect(Collectors.toList()));
        request.getRequestDispatcher("/pages/showRoom.jsp").forward(request, response);
    }
}
