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
}
