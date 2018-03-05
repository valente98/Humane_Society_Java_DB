package com.company;

import java.util.Scanner;

public class UserInteraction {
    // introduction to the user
    Scanner user_input = new Scanner(System.in);
    public Scanner introduction(){
        System.out.println("Hello Welcome to Humane Society in Oxford, Ms");
        System.out.println("What kind of animal are you looking to adopt? " +
                "\n\t1. Dog" +
                "\n\t2. Cat" +
                "\n\t3. Other");
        Scanner animal_type = user_input;
        return animal_type;
    }
}
