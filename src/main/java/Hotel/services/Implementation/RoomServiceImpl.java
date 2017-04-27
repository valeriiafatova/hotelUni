package Hotel.services.Implementation;

import Hotel.model.Reservation;
import Hotel.model.Room;
import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.services.RoomService;

import java.sql.Date;
import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class RoomServiceImpl extends CrudServiceImpl<Room> implements RoomService {
    RoomDao roomDao;
    ReservationDao reservationDao;

    public RoomServiceImpl(RoomDao roomDao, ReservationDao reservationDao) {
        this.roomDao = roomDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public AbstractDao<Room> getCorrespondingDao() {
        return this.roomDao;
    }

    @Override
    public boolean isFree(int id, Date dateIn, Date dateOut) {
        List<Reservation> list = reservationDao.getByRoomId(id);
        for (Reservation reservation : list) {
            if (dateIn.after(reservation.getDateOut()) && dateOut.before(reservation.getDateIn())) {
                return true;
            }
        }
        return false;
    }
}
