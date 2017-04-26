package Hotel.model;

import java.util.List;

/**
 * Created by lerafatova on 27.04.17.
 */
public class User {
    private int id;
    private String name;
    private String phone;
    private List<Reservation> reservationList;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public User(String name, String phone, List<Reservation> reservationList) {
        this.name = name;
        this.phone = phone;
        this.reservationList = reservationList;
    }

    public User(int id, String name, String phone, List<Reservation> reservationList) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.reservationList = reservationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
