package com.company;

import java.sql.*;
// this class will connect to the database in postgresql
public class JDBCConnection {
    public static Connection getDatabase() {
        try{
            return DriverManager.getConnection("jdbc:postgresql:Humane_Society", "basecamp", "localpassword");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
