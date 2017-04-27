package Hotel.services.Implementation;

import Hotel.model.Subscriber;
import Hotel.persistance.DaoInterfaces.AbstractDao;
import Hotel.persistance.DaoInterfaces.SubscriberDao;
import Hotel.services.SubscriberService;

/**
 * Created by lerafatova on 27.04.17.
 */
public class SubscriberServiceImpl extends CrudServiceImpl<Subscriber> implements SubscriberService {
    SubscriberDao subscriberDao;

    public SubscriberServiceImpl(SubscriberDao subscriberDao) {
        this.subscriberDao = subscriberDao;
    }

    @Override
    public AbstractDao<Subscriber> getCorrespondingDao() {
        return this.subscriberDao;
    }
}
