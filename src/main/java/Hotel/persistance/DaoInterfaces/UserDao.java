package Hotel.persistance.DaoInterfaces;

import Hotel.model.User;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface UserDao extends AbstractDao<User> {

    User getUserWithReservation(int id);
}
