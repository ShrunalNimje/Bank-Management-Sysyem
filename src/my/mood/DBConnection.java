package my.mood;

import java.sql.*;

public class DBConnection {

    Connection c;
    Statement s;
    public DBConnection(){

        try{
            c = DriverManager.getConnection("jdbc:mysql:///PlanetEcosystems", "root", "Shrunal#2383");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}

