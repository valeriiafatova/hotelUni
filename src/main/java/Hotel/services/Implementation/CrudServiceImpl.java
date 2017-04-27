package Hotel.services.Implementation;

import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.services.CrudService;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public abstract class CrudServiceImpl<T> implements CrudService<T>{


    public abstract AbstractDao<T> getCorrespondingDao();

    @Override
    public int create(T entity) {
        return getCorrespondingDao().create(entity);
    }

    @Override
    public T findById(int id) {
        return getCorrespondingDao().findById(id);
    }

    @Override
    public boolean update(T entity) {
        return getCorrespondingDao().update(entity);
    }

    @Override
    public boolean delete(int id) {
        return getCorrespondingDao().delete(id);
    }

    @Override
    public List<T> findAll() {
        return getCorrespondingDao().findAll();
    }
}
