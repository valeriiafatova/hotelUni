package Hotel.persistance.JdbcImpl;

import Hotel.model.Room;
import Hotel.model.User;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.persistance.DaoInterfaces.UserDao;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by lerafatova on 28.04.17.
 */
public class RoomDaoJdbcImplTest extends TestCase {

    @Test
    public void testFindAll() throws Exception {
        DaoFactory daoFactory = DaoFactory.getDaoFactoryTest();
        RoomDao roomDao = daoFactory.getRoomDao();

        List<Room> list = roomDao.findAll();
        assertTrue(list.size() != 0);
    }

}