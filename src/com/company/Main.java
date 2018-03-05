package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        // this will ask the user what kind of animal its looking for.
        UserInteraction user = new UserInteraction();
        String animal_type = user.introduction();
        user.animal_type(animal_type);

    }
}
