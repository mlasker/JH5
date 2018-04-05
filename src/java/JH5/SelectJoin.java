package JH5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import myConnection.MyConnection;

public class SelectJoin {
    
    private Connection con;
    private Statement statement;

    public SelectJoin() throws SQLException {

        MyConnection mc = new MyConnection();
        this.con = mc.getConnection();
        this.statement = this.con.createStatement();
    }

    public void joinResults() throws SQLException {
        
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
    
    public static void main(String[] args) throws SQLException {

        SelectJoin sj = new SelectJoin();
        
        sj.joinResults();
    }
}
