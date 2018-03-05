package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class animalsRepository {
    public static void getAnimals(String animal_type){
        try {
            Connection conn = JDBCConnection.getDatabase();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Animals WHERE species =?");
            preparedStatement.setString(1,animal_type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("breed"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
