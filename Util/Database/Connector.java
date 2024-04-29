package Util.Database;

import java.sql.*;

public class Connector {
    Connection con;
    public Connector(String username, String password, String host, String database) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,username,password);

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public Connector(String database) {
        String username = "root";
        String password = "root";
        String host = "localhost:3066";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,username,password);

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

