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
            connector.close();
        } else {
            connector.close();
            throw new Exception("User Already Exist");
        }
    }
    public static void login(User user, int session) throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        ResultSet control = connector.query("SELECT count(*) FROM user WHERE email='" + user.email + "' AND password='" + user.password + "';");
        if (control.getInt("count(*)") == 1) {
            int user_id = connector.query("SELECT id FROM user WHERE email='" + user.email + "';").getInt("id");
            connector.insert("INSERT INTO session (id, user_id, last_login)" +
                    " VALUES (" + session + ", "+ user_id +", NOW());");
        }
        connector.close();
    }

    public static void logout(int session) throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        connector.insert("DELETE FROM session WHERE id='"+session+"';");
        connector.close();
    }

    public static User getUser(int session_id) throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        ResultSet control = connector.query("SELECT user.id,user.email,user.name,user.surname FROM user,session WHERE session.user_id=user.id AND session.id='" + session_id + "';");
        connector.close();
        return new User(control.getString(1),control.getString(2), control.getString(3),control.getString(0));
    }
}
