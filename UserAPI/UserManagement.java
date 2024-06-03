package UserAPI;

import Util.Database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {
    /**
     * @author Leon Rosamilia
     * @param user is the user object
     * @throws Exception
     */
    public static void create(User user) throws Exception {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        ResultSet rs = connector.query("SELECT count(*) FROM user WHERE email="+user.email);
        if (rs.getInt("count(*)") == 0) {
            connector.insert("INSERT INTO user (name, surname, email, password) VALUES ('" + user.name + "','" + user.surname + "','" + user.email + "','" + user.password + "');");
        } else {
            throw new Exception("User Already Exist");
        }
    }
    public static void login(User user, String session) throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        ResultSet rs = connector.query("SELECT count(*) FROM user WHERE email='" + user.email + "' AND password='" + user.password + "';");
        if (rs.getInt("count(*)") == 1) {

        }
    }
}
