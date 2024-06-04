package MessageAPI;

import Util.Database.Connector;

import java.time.LocalDate;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageManagement {
    public static void send(int from, int to, String text) throws SQLException {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        connector.insert("INSERT INTO session (send_user,dest_user,s_time,text) VALUES (" + from + "," + to + ",'" + formattedDate + "','" + text + "');");
        connector.close();
    }
}
