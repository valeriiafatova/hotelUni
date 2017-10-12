package Hotel.persistance.JdbcImpl;

import Hotel.model.Subscriber;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.SubscriberDao;
import Hotel.persistance.MapFunction.SubscriberMapper;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class SubscriberDaoJdbcImpl extends AbstractDaoJdbcImpl<Subscriber> implements SubscriberDao {
    public SubscriberDaoJdbcImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    public static final String SUBSCRIBER_TABLE = "subscriber";

    public static final String SUBSCRIBER_COLUMN_ID = "id";
    public static final String SUBSCRIBER_COLUMN_NAME = "name";
    public static final String SUBSCRIBER_COLUMN_EMAIL = "email";

    private static final String SELECT_ROOM_BY_ID = "SELECT * FROM " + SUBSCRIBER_TABLE + " WHERE " + SUBSCRIBER_COLUMN_ID + " = ?";

    private static final String SELECT_ALL = "SELECT * FROM " + SUBSCRIBER_TABLE;

    private static final String INSERT = "INSERT INTO " + SUBSCRIBER_TABLE + " (" + SUBSCRIBER_COLUMN_NAME + ", "
            + SUBSCRIBER_COLUMN_EMAIL + " "
            + "VALUES (?, ?) ";

    public static final String UPDATE = "UPDATE " + SUBSCRIBER_TABLE + " SET "
            + SUBSCRIBER_COLUMN_NAME + " = ?, "
            + SUBSCRIBER_COLUMN_EMAIL + " = ? "
            + "WHERE + " + SUBSCRIBER_COLUMN_ID + " = ?";

    private static final String DELETE = "DELETE FROM " + SUBSCRIBER_TABLE + " WHERE " + SUBSCRIBER_COLUMN_ID + " = ?";

    @Override
    public int create(Subscriber entity) {
        return create(INSERT, statement -> {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getEmail());
        });
    }

    @Override
    public Subscriber findById(int id) {
        return find(SELECT_ROOM_BY_ID, statement -> statement.setInt(1, id), new SubscriberMapper(daoFactory));
    }

    @Override
    public boolean delete(int id) {
        return delete(DELETE, statement -> statement.setInt(1, id));
    }

    @Override
    public boolean update(Subscriber entity) {
        return update(UPDATE, statement -> {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getEmail());
            statement.setInt(3, entity.getId());
        });
    }

    @Override
    public List<Subscriber> findAll() {
        return findAll(SELECT_ALL, new SubscriberMapper(daoFactory));
    }
}
