package Hotel.persistance.MapFunction;

import Hotel.model.Reservation;
import Hotel.persistance.Connection.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class ReservationMapper extends Mapper<Reservation> {
    public ReservationMapper(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Reservation parse(ResultSet set) throws SQLException {
        return set != null? new Reservation(set.getInt("idreservation"),
                daoFactory.getUserDao().findById(set.getInt("idUser")),
                daoFactory.getRoomDao().findById(set.getInt("idRoom")),
                set.getDate("dateIn"),
                set.getDate("dateOut")) : null;
    }
}
