package Hotel.model;

import Hotel.enums.RoomType;

/**
 * Created by lerafatova on 27.04.17.
 */
public class Room {
    private int id;
    private int floor;
    private int number;
    private int roomCount;
    private int price;
    private RoomType roomType;

    public Room(int id, int floor, int number, int roomCount, int price, String roomType) {
        this.id = id;
        this.floor = floor;
        this.number = number;
        this.roomCount = roomCount;
        this.price = price;
        this.roomType = RoomType.getRoomType(roomType);
    }

    public Room(int floor, int number, int roomCount, int price, String roomType) {
        this.floor = floor;
        this.number = number;
        this.roomCount = roomCount;
        this.price = price;
        this.roomType = RoomType.getRoomType(roomType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
