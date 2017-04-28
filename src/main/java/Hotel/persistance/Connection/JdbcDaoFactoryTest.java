package Hotel.persistance.Connection;

import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.persistance.DaoInterfaces.SubscriberDao;
import Hotel.persistance.DaoInterfaces.UserDao;
import Hotel.persistance.JdbcImpl.ReservationDaoJdbcImpl;
import Hotel.persistance.JdbcImpl.RoomDaoJdbcImpl;
import Hotel.persistance.JdbcImpl.SubscriberDaoJdbcImpl;
import Hotel.persistance.JdbcImpl.UserDaoJdbcImpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lerafatova on 07.04.17.
 */
public class JdbcDaoFactoryTest extends DaoFactory {
    String driverManager = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/hotel";
    String user = "root";
    String password = "Tochilka1";

    public JdbcDaoFactoryTest() {
        try {
            Class.forName(driverManager);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoJdbcImpl(this);
    }

    @Override
    public ReservationDao getReservationDao() {
        return new ReservationDaoJdbcImpl(this);
    }

    @Override
    public RoomDao getRoomDao() {
        return new RoomDaoJdbcImpl(this);
    }

    @Override
    public SubscriberDao getSubscriberDao() {
        return new SubscriberDaoJdbcImpl(this);
    }
}
