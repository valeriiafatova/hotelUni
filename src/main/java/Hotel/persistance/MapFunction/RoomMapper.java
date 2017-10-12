package Hotel.persistance.MapFunction;

import Hotel.model.Room;
import Hotel.persistance.Connection.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class RoomMapper extends Mapper<Room>{
    public RoomMapper(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Room parse(ResultSet set) throws SQLException {
        return set != null? new Room(set.getInt("id"),
                set.getInt("floor"),
                set.getInt("number"),
                set.getInt("roomCount"),
                set.getInt("price"),
                set.getString("type")) : null;
    }
}
