package Hotel.services;


import Hotel.model.User;

/**
 * Created by lerafatova on 14.04.17.
 */
public interface UserService extends CrudService<User> {

    boolean userIsExistsByPhone(String phone);

    User getUserByPhone(String phone);

    User getUserWithReservation(int id);

}
