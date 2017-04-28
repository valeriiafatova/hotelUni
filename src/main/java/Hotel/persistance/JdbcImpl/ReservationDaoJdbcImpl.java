package Hotel.persistance.JdbcImpl;

import Hotel.model.Reservation;
import Hotel.persistance.Connection.DaoFactory;
import Hotel.persistance.DaoInterfaces.ReservationDao;
import Hotel.persistance.MapFunction.ReservationMapper;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class ReservationDaoJdbcImpl extends AbstractDaoJdbcImpl<Reservation> implements ReservationDao {


    public ReservationDaoJdbcImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    public static final String RESERVATION_TABLE = "reservation";

    public static final String RESERVATION_COLUMN_ID = "id";
    public static final String RESERVATION_COLUMN_ID_ROOM = "idRoom";
    public static final String RESERVATION_COLUMN_ID_USER = "idUser";
    public static final String RESERVATION_COLUMN_ID_DATE_IN = "dateIn";
    public static final String RESERVATION_COLUMN_ID_DATE_OUT = "dateOut";

    private static final String SELECT_RESERVATION_BY_ID = "SELECT * FROM " + RESERVATION_TABLE + " WHERE " + RESERVATION_COLUMN_ID + " = ?";
    private static final String SELECT_RESERVATION_BY_USER = "SELECT * FROM " + RESERVATION_TABLE + " where " + RESERVATION_COLUMN_ID_USER + " = ?";
    private static final String SELECT_RESERVATION_BY_ROOM = "SELECT * FROM " + RESERVATION_TABLE + " where " + RESERVATION_COLUMN_ID_ROOM + " = ?";

    private static final String SELECT_ALL = "SELECT * FROM " + RESERVATION_TABLE;

    private static final String INSERT = "INSERT INTO " + RESERVATION_TABLE + " (" + RESERVATION_COLUMN_ID_ROOM + ", "
            + RESERVATION_COLUMN_ID_USER + ", "
            + RESERVATION_COLUMN_ID_DATE_IN + ", "
            + RESERVATION_COLUMN_ID_DATE_OUT + ") "
            + "VALUES (?, ?, ?, ?) ";

    public static final String UPDATE = "UPDATE " + RESERVATION_TABLE + " SET "
            + RESERVATION_COLUMN_ID_ROOM + " = ?, "
            + RESERVATION_COLUMN_ID_USER + " = ?, "
            + RESERVATION_COLUMN_ID_DATE_IN + " = ?, "
            + RESERVATION_COLUMN_ID_DATE_OUT + " = ? "
            + "WHERE + " + RESERVATION_COLUMN_ID + " = ?";

    private static final String DELETE = "DELETE FROM " + RESERVATION_TABLE + " WHERE " + RESERVATION_COLUMN_ID + " = ?";

    @Override
    public int create(Reservation entity) {
        return create(INSERT, statement -> {
            statement.setInt(1, entity.getRoom().getId());
            statement.setInt(2, entity.getUser().getId());
            statement.setDate(3, entity.getDateIn());
            statement.setDate(4, entity.getDateOut());
        });
    }

    @Override
    public Reservation findById(int id) {
        return find(SELECT_RESERVATION_BY_ID, statement -> statement.setInt(1, id), new ReservationMapper(daoFactory));
    }

    @Override
    public boolean delete(int id) {
        return delete(DELETE, statement -> statement.setInt(1, id));
    }

    @Override
    public boolean update(Reservation entity) {
        return update(UPDATE, statement -> {
            statement.setInt(1, entity.getRoom().getId());
            statement.setInt(2, entity.getUser().getId());
            statement.setDate(3, entity.getDateIn());
            statement.setDate(4, entity.getDateOut());
            statement.setInt(5, entity.getId());
        });
    }

    @Override
    public List<Reservation> findAll() {
        return findAll(SELECT_ALL, new ReservationMapper(daoFactory));
    }

    @Override
    public List<Reservation> getByUserId(int userId) {
        return findAll(SELECT_RESERVATION_BY_USER, statement -> statement.setInt(1, userId), new ReservationMapper(daoFactory));
    }

    @Override
    public List<Reservation> getByRoomId(int roomId) {
        return findAll(SELECT_RESERVATION_BY_ROOM, statement -> statement.setInt(1, roomId), new ReservationMapper(daoFactory));
    }
}
