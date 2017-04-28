package Hotel.persistance.JdbcImpl;

import Hotel.model.Reservation;
import Hotel.model.Room;
import Hotel.model.User;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.ReservationDao;
import junit.framework.TestCase;

import java.sql.Date;

/**
 * Created by lerafatova on 28.04.17.
 */
public class ReservationDaoJdbcImplTest extends TestCase {

    public void testCreate() throws Exception {
        DaoFactory daoFactory = DaoFactory.getDaoFactoryTest();
        ReservationDao reservationDao = daoFactory.getReservationDao();
        User user = new User(1, null, null);
        Room room = new Room(1, 0, 0, 0, 0, "lux");

        Reservation reservation = new Reservation(user, room, new Date(2017, 06, 20), new Date(2017, 06, 22));
        int id = reservationDao.create(reservation);
        System.out.println(id);
    }
}