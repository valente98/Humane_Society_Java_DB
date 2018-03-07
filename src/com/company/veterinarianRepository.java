package com.company;

import java.sql.*;

public class veterinarianRepository {
    public static void insert_animals(String name, String species, String breed, String m_or_f, Double age, String size,
                                      String color, Date intake_date, String location, Boolean housetrained, Boolean declawed,
                                      Boolean Sp_Ne){
        try{
            Connection conn = JDBCConnection.getDatabase();
            PreparedStatement preparedStatement = conn.prepareStatement("Insert into Animals(name, species, breed, male_female, age, size, color,"+
                    " intake_date, location, housetrained, declawed, spayed_or_neutured) Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, species);
            preparedStatement.setString(3, breed);
            preparedStatement.setString(4, m_or_f);
            preparedStatement.setDouble(5, age);
            preparedStatement.setString(6, size);
            preparedStatement.setString(7, color);
            preparedStatement.setDate(8, intake_date);
            preparedStatement.setString(9, location);
            preparedStatement.setBoolean(10, housetrained);
            preparedStatement.setBoolean(11, declawed);
            preparedStatement.setBoolean(12, Sp_Ne);
            preparedStatement.execute();
            System.out.println(name + " has been added to the shelter.");
            preparedStatement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
