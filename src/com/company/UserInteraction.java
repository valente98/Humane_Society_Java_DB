package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInteraction {
    // introduction to the user
    JDBCConnection animal = new JDBCConnection();
    public String introduction(){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Hello Welcome to Humane Society in Oxford, Ms");
        System.out.println("What kind of animal are you looking to adopt? " +
                "\n\t1. Dog" +
                "\n\t2. Cat" +
                "\n\t3. Other");
        String animal_type = user_input.next();
        return animal_type;
    }
    public void animal_type(String type) throws SQLException {
        if (type.equals("1")){
            dog();
        }else if (type.equals("2")) {
            cat();
        }else if (type.equals("3")){
            other();
        }else{
            System.out.println("Sorry invalid answer");
        }
    }
    public void dog() throws SQLException {
        Scanner user_input = new Scanner(System.in);
        animalsRepository.getAnimals("dog");
        System.out.println("What breed of dog are you looking for?");
        String dog_breed = user_input.next();

    }
    public void cat(){
    }
    public void other(){
    }
}
