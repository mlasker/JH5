package JH5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.MyConnection;

public class CreateStates {

    private Connection con;
    private Statement statement;

    public CreateStates() throws SQLException {

        MyConnection mc = new MyConnection();
        this.con = mc.getConnection();
        this.statement = this.con.createStatement();
    }

    public void makeTable() throws SQLException {

        try {
            statement.executeUpdate(
                    "create table states ("
                    + "StateName varchar(50) Primary Key,"
                    + "Region ENUM('east', 'midwest', 'west', 'south', 'southwest'),"
                    + "LargestCity varchar(50),"
                    + "Capital varchar(50),"
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
                "insert into jh5.states (StateName, Region, LargestCity, Capital, Population) values"
//                + "('Michigan', 'midwest', 'Detroit', 'Lansing', 9962311),"
                + "('Florida', 'south', 'Jacksonville', 'Tallahassee', 20984400),"
                + "('California', 'west', 'Los Angeles', 'Sacramento', 39536653),"
                + "('Arizona', 'southwest', 'Phoenix', 'Phoenix', 6931071);"
        );
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void printResults() throws SQLException {
        
        ResultSet results = this.statement.executeQuery(
                "select * from states"
        );

        while (results.next()) {
            System.out.print("Name: " + results.getString("StateName"));
            System.out.print(" Region: " + results.getString("region"));
            System.out.print(" Largest City: " + results.getString("LargestCity"));
            System.out.print(" Capital: " + results.getString("Capital"));
            System.out.println(" Population: " + results.getString("Population"));
        }
    }

    public static void main(String[] args) throws SQLException {

        CreateStates cs = new CreateStates();
        cs.makeTable();
        cs.fillTable();
        cs.printResults();
    }
}
