package Hotel.persistance.JdbcImpl;

import Hotel.model.Room;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.RoomDao;
import Hotel.persistance.MapFunction.RoomMapper;

import java.sql.Date;
import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class RoomDaoJdbcImpl extends AbstractDaoJdbcImpl<Room> implements RoomDao {
    public RoomDaoJdbcImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    public static final String ROOM_TABLE = "room";

    public static final String ROOM_COLUMN_ID = "id";
    public static final String ROOM_COLUMN_FLOOR = "floor";
    public static final String ROOM_COLUMN_NUMBER = "number";
    public static final String ROOM_COLUMN_ROOM_COUNT = "roomCount";
    public static final String ROOM_COLUMN_PRICE = "price";
    public static final String ROOM_COLUMN_TYPE = "type";

    private static final String SELECT_ROOM_BY_ID = "SELECT * FROM " + ROOM_TABLE + " WHERE " + ROOM_COLUMN_ID + " = ?";

    private static final String SELECT_ALL = "SELECT * FROM " + ROOM_TABLE;

    private static final String INSERT = "INSERT INTO " + ROOM_TABLE + " (" + ROOM_COLUMN_FLOOR + ", "
            + ROOM_COLUMN_NUMBER + ", "
            + ROOM_COLUMN_ROOM_COUNT + ", "
            + ROOM_COLUMN_PRICE + ", "
            + ROOM_COLUMN_TYPE + " "
            + "VALUES (?, ?) ";

    public static final String UPDATE = "UPDATE " + ROOM_TABLE + " SET "
            + ROOM_COLUMN_FLOOR + " = ?, "
            + ROOM_COLUMN_NUMBER + " = ?, "
            + ROOM_COLUMN_ROOM_COUNT + " = ?, "
            + ROOM_COLUMN_PRICE + " = ?, "
            + ROOM_COLUMN_TYPE + " = ? "
            + "WHERE + " + ROOM_COLUMN_ID + " = ?";

    private static final String DELETE = "DELETE FROM " + ROOM_TABLE + " WHERE " + ROOM_COLUMN_ID + " = ?";

    @Override
    public int create(Room entity) {
        return create(INSERT, statement -> {
            statement.setInt(1, entity.getId());
            statement.setInt(2, entity.getFloor());
            statement.setInt(3, entity.getNumber());
            statement.setInt(4, entity.getRoomCount());
            statement.setInt(5, entity.getPrice());
            statement.setString(6, entity.getRoomType().name());
        });
    }

    @Override
    public Room findById(int id) {
        return find(SELECT_ROOM_BY_ID, statement -> statement.setInt(1, id), new RoomMapper(daoFactory));
    }

    @Override
    public boolean delete(int id) {
        return delete(DELETE, statement -> statement.setInt(1, id));
    }

    @Override
    public boolean update(Room entity) {
        return update(UPDATE, statement -> {
            statement.setInt(1, entity.getFloor());
            statement.setInt(2, entity.getNumber());
            statement.setInt(3, entity.getRoomCount());
            statement.setInt(4, entity.getPrice());
            statement.setString(5, entity.getRoomType().name());
            statement.setInt(6, entity.getId());
        });
    }

    @Override
    public List<Room> findAll() {
        return findAll(SELECT_ALL, new RoomMapper(daoFactory));
    }

}
