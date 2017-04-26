package Hotel.model;

import java.sql.Date;

/**
 * Created by lerafatova on 27.04.17.
 */
public class Reservation {
    private int id;
    private User user;
    private Room room;
    private Date dateIn;
    private Date dateOut;

    public Reservation(User user, Room room, Date dateIn, Date dateOut) {
        this.user = user;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public Reservation(int id, User user, Room room, Date dateIn, Date dateOut) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
