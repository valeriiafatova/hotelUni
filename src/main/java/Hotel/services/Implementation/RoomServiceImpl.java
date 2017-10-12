package Hotel.services.Implementation;

import Hotel.model.Reservation;
import Hotel.model.Room;
import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.services.RoomService;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class RoomServiceImpl extends CrudServiceImpl<Room> implements RoomService {
    RoomDao roomDao;
    ReservationDao reservationDao;
    private static final Logger LOGGER = Logger.getLogger(RoomServiceImpl.class);

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
        LOGGER.debug("list: " + list.size());
        if(list.size() == 0) return true;
        for (Reservation reservation : list) {
            LOGGER.debug("reservation: " + reservation.getDateIn() + " " +reservation.getDateOut());
            LOGGER.debug("reservation: " + dateIn + " " +dateOut);
            LOGGER.debug("reservation: " + dateIn.after(reservation.getDateOut()));
            LOGGER.debug("reservation: " + dateOut.before(reservation.getDateIn()));
            if (dateIn.after(reservation.getDateOut()) || dateOut.before(reservation.getDateIn())) {
                return true;
            }
        }
        return false;
    }
}
