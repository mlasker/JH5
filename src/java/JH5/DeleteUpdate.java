package JH5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.MyConnection;

public class DeleteUpdate {
    
    private Connection con;
    private Statement statement;

    public DeleteUpdate() throws SQLException {

        MyConnection mc = new MyConnection();
        this.con = mc.getConnection();
        this.statement = this.con.createStatement();
    }

    public void printResults() throws SQLException {
        
        ResultSet results = this.statement.executeQuery(
                "select CityName, cities.StateName, cities.Population, Region " +
                "FROM cities JOIN states on cities.StateName = states.Statename;"
        );
        
        while (results.next()) {
            System.out.print("City Name: " + results.getString("CityName"));
            System.out.print(" State Name: " + results.getString("StateName"));
            System.out.print(" Region: " + results.getString("Region"));
            System.out.println(" Population: " + results.getString("Population"));
        }
    }
    
    public void deleteTopCity() throws SQLException {
        
        this.statement.executeUpdate(
                "delete from cities " +
                "order by population desc " +
                "limit 1;"
        );
    }
    
    public void updateCity() throws SQLException {
        
        this.statement.executeUpdate(
                "update cities " +
                "set population = 0 " +
                "where CityName = 'San Jose';"
        );
    }
    
    public static void main(String[] args) throws SQLException {

        DeleteUpdate du = new DeleteUpdate();
        du.printResults();
        du.deleteTopCity();
        System.out.println("*********AFTER DELETING****************");
        du.printResults();
        du.updateCity();
        System.out.println("*********AFTER UPDATING****************");
        du.printResults();
    }
}
