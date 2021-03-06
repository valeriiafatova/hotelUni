package Hotel.model;

/**
 * Created by lerafatova on 27.04.17.
 */
public class Subscriber {
    private int id;
    private String name;
    private String email;

    public Subscriber(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Subscriber(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
