package MessageAPI;

import UserAPI.User;
import Util.Database.Connector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageManagement {
    /**
     *
     * @param cookie is the cookie id from the user
     * @param to is the email of the receiver
     * @param text is the text of the message
     * @throws SQLException if the DB gets an error it throws that
     */
    public static void send(int cookie, String to, String text) throws SQLException {
        text = text.replace("'","Ƀ");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Connector connector = new Connector("root","root","192.168.56.101","messages");
        ResultSet res = connector.query("SELECT session.user_id FROM session,user WHERE session.id = " + cookie);
        String id = res.getString(0);
        ResultSet res2 = connector.query("SELECT id FROM user WHERE email='" + to + "';");
        String id2 = res.getString(0);
        connector.insert("INSERT INTO session (send_user,dest_user,s_time,text) VALUES (" + id + "," + id2 + ",'" + formattedDate + "','" + text + "');");
        connector.insert("");
        connector.close();
    }

    public static void read(int cookie, String to, String dateFrom, String dateTo) throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","messages");
        ResultSet res = connector.query("SELECT text, s_time, send_user FROM message WHERE send_user=(SELECT session.user_id FROM session,user WHERE session.id = " + cookie + ") AND dest_user=(SELECT id FROM user WHERE email='" + to + "') AND s_time > '" + dateFrom + "' AND s_time < '" + dateTo + "';");
        List<Message> messages;
        /*User usr1 =
        while (res.next()) {
            Message message = new Message(,)
        }*/
    }
}
