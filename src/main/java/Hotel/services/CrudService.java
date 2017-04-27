package Hotel.services;

import java.util.List;

/**
 * Created by lerafatova on 12.04.17.
 */
public interface CrudService<T> {

    int create(T entity);
    boolean update(T entity);
    boolean delete(int id);
    <T> T findById(int id);
    List<T> findAll();
}
