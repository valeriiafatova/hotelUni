package Hotel.controller.Command;

import Hotel.enums.RoomType;
import Hotel.factory.ServiceFactory;
import Hotel.model.Room;
import Hotel.services.RoomService;

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
    RoomService roomService = ServiceFactory.getInstance().getRoomService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> list = roomService.findAll();
        RoomType roomType = RoomType.valueOf(request.getParameter("type"));

        request.setAttribute("rooms", list.stream().filter(e-> e.getRoomType() == roomType).collect(Collectors.toList()));
    }
}
