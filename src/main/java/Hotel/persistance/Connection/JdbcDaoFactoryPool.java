package Hotel.persistance.Connection;

import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.persistance.DaoInterfaces.SubscriberDao;
import Hotel.persistance.DaoInterfaces.UserDao;
import Hotel.persistance.JdbcImpl.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lerafatova on 02.04.17.
 */
public class JdbcDaoFactoryPool extends DaoFactory{


    @Override
    public Connection getConnection() throws SQLException {

        DataSource dataSource = null;
        try {Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/confluence");
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return dataSource.getConnection();
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
