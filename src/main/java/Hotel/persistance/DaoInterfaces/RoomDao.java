package Hotel.persistance.DaoInterfaces;

import Hotel.model.Room;

import java.sql.Date;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface RoomDao extends AbstractDao<Room> {

    boolean isFree(int id, Date dateInt, Date dateOut);
}
