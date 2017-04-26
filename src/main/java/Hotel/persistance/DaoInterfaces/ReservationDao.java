package Hotel.persistance.DaoInterfaces;

import Hotel.model.Reservation;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface ReservationDao extends AbstractDao<Reservation> {

    Reservation getByUserId(int userId);
}
