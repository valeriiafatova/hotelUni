package Hotel.persistance.JdbcImpl;

import Hotel.model.User;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.UserDao;
import junit.framework.TestCase;

/**
 * Created by lerafatova on 28.04.17.
 */
public class UserDaoJdbcImplTest extends TestCase {

    public void testCreate() throws Exception {
            DaoFactory daoFactory = DaoFactory.getDaoFactoryTest();
            UserDao userDao = daoFactory.getUserDao();
            User user = new User("vasya", "04857223");
            int id = userDao.create(user);
            System.out.println(id);

    }
}