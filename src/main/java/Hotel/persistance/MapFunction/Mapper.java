package Hotel.persistance.MapFunction;


import Hotel.persistance.Connection.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lerafatova on 02.04.17.
 */
public abstract class Mapper<T> {
    protected DaoFactory daoFactory;

    public Mapper(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public abstract T parse(ResultSet set) throws SQLException;
}
