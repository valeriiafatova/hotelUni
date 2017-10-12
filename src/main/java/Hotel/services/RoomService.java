package Hotel.services;

import Hotel.model.Room;

import java.sql.Date;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface RoomService extends CrudService<Room> {

    boolean isFree(int id, Date dateIn, Date dateOut);
}
