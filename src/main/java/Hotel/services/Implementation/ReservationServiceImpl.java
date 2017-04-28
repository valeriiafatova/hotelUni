package Hotel.services.Implementation;

import Hotel.model.Reservation;
import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.services.ReservationService;
import Hotel.services.RoomService;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class ReservationServiceImpl extends CrudServiceImpl<Reservation> implements ReservationService {
    ReservationDao reservationDao;

    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public AbstractDao<Reservation> getCorrespondingDao() {
        return this.reservationDao;
    }

    @Override
    public List<Reservation> getByUserId(int userId) {
        return reservationDao.getByUserId(userId);
    }

    @Override
    public List<Reservation> getByRoomId(int roomId) {
        return reservationDao.getByRoomId(roomId);
    }
}
