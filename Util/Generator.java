package Util;

import Util.Database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Generator {
    public static int sessionId() throws SQLException {
        Connector connector = new Connector("root","root","192.168.56.101","logistic");
        ResultSet rs = connector.query("SELECT max(id) FROM session");
        connector.close();
        return rs.getInt("id");
    }
}
