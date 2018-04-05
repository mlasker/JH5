package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    private Connection con;
    
    public MyConnection() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/jh5";
        String username = "root";
        String password = "kotht7s";

        System.out.println("Connecting database...");
        
        try {
            this.con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        }
        catch (SQLException e) {
            System.out.println("Cant connect");
        }
    }
    
    public Connection getConnection(){
        
        return this.con;
    }
}
