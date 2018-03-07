package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class UserInteraction {
    // introduction to the user
    JDBCConnection animal = new JDBCConnection();
    Scanner user_input = new Scanner(System.in);
    public String introduction(){
        System.out.println("Hello Welcome to Humane Society in Oxford, Ms");
        System.out.println("What kind of animal are you looking to adopt? " +
                "\n\t1. Dog" +
                "\n\t2. Cat" +
                "\n\t3. Other");
        String animal_type = user_input.nextLine();
        return animal_type;
    }
    public void animal_type(String type) throws SQLException {
        if (type.equals("1")){
            dog();
        }else if (type.equals("2")) {
            cat();
        }else if (type.equals("3")){
            other();
        }else if(type.equals("veterinarian")){
            veterinary();
        }else{
            System.out.println("Sorry invalid answer");
        }
    }

    public void veterinary() throws SQLException{
        System.out.println("Password: ");
        String passsword = user_input.nextLine();
        if (passsword.equals("veterinarian#1")){
            System.out.println("Welcome what would you like to do? \n\t1.Insert an animal\n\t2.Take out an animal");
            String vet_choice = user_input.nextLine();
            if (vet_choice.equals("1")){
                insert_animal();
            }else if (vet_choice.equals("2")){
                take_animal_away();
            }else{
                System.out.println("Sorry. Invalid Choice.");
            }
        }else{
            System.out.println("Sorry. Invalid Choice.");
        }

    }

    public void take_animal_away(){
        System.out.println("What is the species of the animal your are trying to take out?");
        String species = user_input.nextLine().toLowerCase();
        animalsRepository.getAnimaltoDelete(species);
        System.out.println("Please type the Id of the animal you are trying to take out.");
        Integer animal_id = Integer.valueOf(user_input.nextLine());
        veterinarianRepository.delete_animal(animal_id);
    }

    public void insert_animal() throws SQLException{
        System.out.println("\nWhat is the name of your animals?");
        String name = user_input.nextLine();
        System.out.println("\nWhat is the Species of "+ name);
        String species = user_input.nextLine().toLowerCase();
        System.out.println("\nWhat is the Breed of "+ name);
        String breed = user_input.nextLine();
        System.out.println("\nIs "+ name + " a male of female");
        String m_or_f = user_input.nextLine();
        System.out.println("\nWhat is the Age of "+ name);
        Double age = Double.parseDouble(user_input.nextLine());
        System.out.println("\nWhat are the colors of " + name);
        String color = user_input.nextLine();
        System.out.println("\nWhat is the size of "+ name);
        String size = user_input.nextLine();
        System.out.println("\nWhat is the Intake date of " + name + " (yyyy-mm-dd)");
        Date intake_date = Date.valueOf(user_input.nextLine());
        System.out.println("\nWhat is the Location of " + name);
        String location = user_input.nextLine();
        System.out.println("\nIs " + name +" house trained? true or false");
        Boolean housetrained = Boolean.parseBoolean(user_input.nextLine());
        System.out.println("\nIs " + name +" Declawed? true or false");
        Boolean declawed = Boolean.parseBoolean(user_input.nextLine());
        System.out.println("\nIs " + name +" Spayed/Neutured? true or false");
        Boolean Spayed_and_neutured = Boolean.parseBoolean(user_input.nextLine());
        veterinarianRepository.insert_animals(name, species, breed, m_or_f, age, size, color, intake_date, location, housetrained, declawed, Spayed_and_neutured);

    }

    public void dog() throws SQLException {
        animalsRepository.getAnimals("dog");
        System.out.println("What breed of dog are you looking for?");
        String dog_breed = user_input.nextLine();
        animalsRepository.getAnimalbybreed(dog_breed);

    }
    public void cat(){
        animalsRepository.getAnimals("cat");
        System.out.println("What breed of dog are you looking for?");
        String cat_breed = user_input.nextLine();
        animalsRepository.getAnimalbybreed(cat_breed);
    }
    public void other(){
    }
}
