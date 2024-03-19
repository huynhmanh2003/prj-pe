/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTBconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public Connection connect() {
        String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ContactDB;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "123456";
        try {
            Class.forName(drivername);
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
                    System.out.println(e);
        }
        return null;

    }
     public static void main(String[] args) {
         System.out.println(new  ConnectDatabase().connect());
    }
}
