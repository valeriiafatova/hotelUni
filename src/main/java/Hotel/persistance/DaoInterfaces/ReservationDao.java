package Hotel.persistance.DaoInterfaces;

import Hotel.model.Reservation;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface ReservationDao extends AbstractDao<Reservation> {

    List<Reservation> getByUserId(int userId);
    List<Reservation> getByRoomId(int roomId);
}
