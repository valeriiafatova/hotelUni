package Hotel.persistance.DaoInterfaces;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public interface AbstractDao<T>  {

    int create(T entity);

    <T> T findById(int id);

    boolean delete(int id);

    boolean update(T entity);

    List<T> findAll();
}
