package Hotel.enums;

/**
 * Created by lerafatova on 27.04.17.
 */
public enum RoomType {
    ECONOMY, STANDARD, LUX;

    public static RoomType getRoomType(String type){
        return RoomType.valueOf(type.toUpperCase());
    }
}
