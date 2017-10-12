package Hotel.persistance.MapFunction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lerafatova on 12.04.17.
 */
public interface PrepareStatementFunc {
    void prepare(PreparedStatement statement) throws SQLException;
}
