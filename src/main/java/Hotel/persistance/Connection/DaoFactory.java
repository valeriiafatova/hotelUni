package Hotel.persistance.Connection;

import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.persistance.DaoInterfaces.SubscriberDao;
import Hotel.persistance.DaoInterfaces.UserDao;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by lerafatova on 02.04.17.
 */
public abstract class DaoFactory {

    public static DaoFactory getDaoFactory(){
        return new JdbcDaoFactoryPool();
    }
    public static DaoFactory getDaoFactoryTest(){
        return new JdbcDaoFactoryTest();
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract UserDao getUserDao();
    public abstract ReservationDao getReservationDao();
    public abstract RoomDao getRoomDao();
    public abstract SubscriberDao getSubscriberDao();
}
