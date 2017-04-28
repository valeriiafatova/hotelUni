package Hotel.persistance.JdbcImpl;

import Hotel.model.User;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.UserDao;
import Hotel.persistance.MapFunction.Mapper;
import Hotel.persistance.MapFunction.UserMapper;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class UserDaoJdbcImpl extends AbstractDaoJdbcImpl<User> implements UserDao {
    public static final String USER_TABLE = "user";

    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_PHONE = "phoneNumber";

    private static final String SELECT_USER_BY_ID = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_COLUMN_ID + " = ?";
    private static final String SELECT_USER_BY_PHONE = "SELECT * FROM " + USER_TABLE + " where " + USER_COLUMN_PHONE + " = ?";

    private static final String SELECT_ALL = "SELECT * FROM " + USER_TABLE;

    private static final String INSERT = "INSERT INTO " + USER_TABLE + " (" + USER_COLUMN_NAME + ", "
            + USER_COLUMN_PHONE + ") "
            + " VALUES (?, ?) ";

    public static final String UPDATE = "UPDATE " + USER_TABLE + " SET "
            + USER_COLUMN_NAME + " = ?, "
            + USER_COLUMN_PHONE + " = ? "
            + "WHERE + " + USER_COLUMN_ID + " = ?";

    private static final String DELETE = "DELETE FROM " + USER_TABLE + " WHERE " + USER_COLUMN_ID + " = ?";

    public UserDaoJdbcImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public User getUserByPhone(String phone) {
        return find(SELECT_USER_BY_PHONE, statement -> statement.setString(1, phone), new UserMapper(daoFactory));
    }

    @Override
    public User getUserWithReservation(int id) {
        User user = findById(id);
        user.setReservationList(daoFactory.getReservationDao().getByUserId(id));
        return user;
    }

    @Override
    public int create(User entity) {
        return create(INSERT, statement -> {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPhone());
        });
    }

    @Override
    public User findById(int id) {
        return find(SELECT_USER_BY_ID, statement -> statement.setInt(1, id), new UserMapper(daoFactory));
    }

    @Override
    public boolean delete(int id) {
        return delete(DELETE, statement -> statement.setInt(1, id));
    }

    @Override
    public boolean update(User entity) {
        return update(UPDATE, statement -> {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPhone());
            statement.setInt(3, entity.getId());
        });
    }

    @Override
    public List<User> findAll() {
        return findAll(SELECT_ALL, new UserMapper(daoFactory));
    }
}
