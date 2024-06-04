package UserAPI;

public class User {
    int id;
    String email;
    String name;
    String surname;
    String password;
    int pp_id;
    public User (String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }
    public User (String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User (String email, String name, String surname, int id) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.surname = surname;
    }

    public String toJSON() {
        return "{\"User\":" + "{\"id\":" + id + "," + " \"email\":\"" + email + "\"," + " \"name\":\"" + name + "\"," + " \"surname\":\"" + surname + "\"}}";
    }
}
