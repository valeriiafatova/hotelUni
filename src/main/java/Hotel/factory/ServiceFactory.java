package Hotel.factory;

import Hotel.persistance.Connection.DaoFactory;
import Hotel.services.*;
import Hotel.services.Implementation.*;

/**
 * Created by lerafatova on 15.04.17.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private DaoFactory daoFactory;
    private ReservationService reservationService;
    private RoomService roomService;
    private SubscriberService subscriberService;
    private UserService userService;

    public ServiceFactory() {
        daoFactory = DaoFactory.getDaoFactory();
        reservationService = new ReservationServiceImpl(daoFactory.getReservationDao());
        roomService = new RoomServiceImpl(daoFactory.getRoomDao(), daoFactory.getReservationDao());
        subscriberService = new SubscriberServiceImpl(daoFactory.getSubscriberDao());
        userService = new UserServiceImpl(daoFactory.getUserDao());
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public SubscriberService getSubscriberService() {
        return subscriberService;
    }

    public UserService getUserService() {
        return userService;
    }
}
