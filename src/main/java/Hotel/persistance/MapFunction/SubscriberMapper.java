package Hotel.persistance.MapFunction;

import Hotel.model.Subscriber;
import Hotel.persistance.Connection.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lerafatova on 27.04.17.
 */
public class SubscriberMapper extends Mapper<Subscriber> {

    public SubscriberMapper(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public Subscriber parse(ResultSet set) throws SQLException {
        return set != null? new Subscriber(set.getInt("id"),
                set.getString("name"),
                set.getString("email")) : null;
    }
}
