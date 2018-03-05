package com.company;

import java.sql.*;

public class JDBCConnection {
    public static Connection getDatabase() {
        try{
            return DriverManager.getConnection("jdbc:postgresql:Animals", "basecamp", "localpassword");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
