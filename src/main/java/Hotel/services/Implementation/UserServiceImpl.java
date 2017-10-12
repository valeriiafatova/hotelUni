package Hotel.services.Implementation;

import Hotel.model.User;
import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.persistance.DaoInterfaces.UserDao;
import Hotel.services.UserService;

/**
 * Created by lerafatova on 27.04.17.
 */
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public AbstractDao<User> getCorrespondingDao() {
        return this.userDao;
    }

    @Override
    public boolean userIsExistsByPhone(String phone) {
        return userDao.getUserByPhone(phone) != null;
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public User getUserWithReservation(int id) {
        return userDao.getUserWithReservation(id);
    }
}
