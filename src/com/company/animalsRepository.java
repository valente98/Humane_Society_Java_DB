package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class animalsRepository {
    // this will show the user the different types of breed.
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

    // this will show all of the information about the animal
    public static void getAnimalbybreed(String animal_breed){
        try{
            Connection conn = JDBCConnection.getDatabase();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Animals WHERE breed =?");
            preparedStatement.setString(1,animal_breed);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("name: "+ resultSet.getString("name") + ", Age: " +
                        resultSet.getString("age")+"M or F: "+
                        resultSet.getString("male_female") + ", Color: " +
                        resultSet.getString("color") + "Size: " +
                        resultSet.getString("size")+ ", Intake Date: " +
                        resultSet.getString("intake_date") +", Location: " +
                        resultSet.getString("location") + ", HouseTrained: " +
                        resultSet.getString("housetrained") + ", Declawed: " +
                        resultSet.getString("declawed") + ", Spayed/Neutured: " +
                        resultSet.getString("spayed_or_neutured") + "\n"
                );
            }
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public  static void getAnimaltoDelete(String animal_type){
        try{
            Connection conn = JDBCConnection.getDatabase();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Animals Where Species= ?");
            preparedStatement.setString(1, animal_type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Id: " + resultSet.getString("animal_id") +
                    ", Name: " + resultSet.getString("name") + ", Breed: " + resultSet.getString("breed")+
                    ", Gender: " + resultSet.getString("male_female") + ", Age: " + resultSet.getString("age")+
                    ", Color: " + resultSet.getString("color") + ", Intake Date: " + resultSet.getString("intake_date"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
