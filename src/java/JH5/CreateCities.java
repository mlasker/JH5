package JH5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.MyConnection;

public class CreateCities {

    private Connection con;
    private Statement statement;

    public CreateCities() throws SQLException {

        MyConnection mc = new MyConnection();
        this.con = mc.getConnection();
        this.statement = this.con.createStatement();
    }

    public void makeTable() throws SQLException {

        try {
            statement.executeUpdate(
                    "create table cities ("
                    + "CityName varchar(50) Primary Key,"
                    + "StateName varchar(50),"
                    + "Population int"
                    + ");"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void fillTable() throws SQLException {
        
        try {
            statement.executeUpdate(
                "insert into cities (CityName, StateName, Population) values"
                + "('Ann Arbor', 'Michigan', 113934),"
                + "('Tempe', 'Arizona', 161719),"
                + "('Miami', 'Florida', 5502379),"
                + "('San Jose', 'California', 1000000),"
                + "('San Francisco', 'California', 8837789);"
            );
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("huh?");
        }
    }
    
    public void printResults() throws SQLException {
        
        ResultSet results = this.statement.executeQuery(
                "select * from cities"
        );

        while (results.next()) {
            System.out.print("City Name: " + results.getString("CityName"));
            System.out.print(" State Name: " + results.getString("StateName"));
            System.out.println(" Population: " + results.getString("Population"));
        }
    }
    
    // Method to remove table for debugging/testing purposes
    public void dropTable() {
        
        try {
            statement.executeUpdate(
                    "DROP TABLE cities"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void main(String[] args) throws SQLException {

        CreateCities cs = new CreateCities();
        cs.makeTable();
        cs.fillTable();
        cs.printResults();
    }
}
