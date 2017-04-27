package Hotel.persistance.MapFunction;

import Hotel.model.User;
import Hotel.persistance.Connection.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class UserMapper extends Mapper<User> {
    public UserMapper(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public User parse(ResultSet set) throws SQLException {
        return set != null? new User(set.getInt("id"), set.getString("name"), set.getString("phoneNumber")) : null;
    }
}
