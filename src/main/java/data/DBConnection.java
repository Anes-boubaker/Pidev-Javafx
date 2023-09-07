package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static Connection con;

public void getDBConn(){
    synchronized (""){
        try {
            if (this.getCon()==null || this.getCon().isClosed()) {
                try {
                    String url = "jdbc:mysql://localhost/pidev";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    setCon(DriverManager.getConnection(url,"root",""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
public  void closeConnection(){
    try {
        con.close();
    }catch(Exception e ) {
        e.printStackTrace();
    }
}



    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DBConnection.con = con;
    }
}
