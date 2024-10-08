package org.example;

import java.util.HashMap;

public class UserManager {
    HashMap<String, User> users = new HashMap<>();

    // Add User (Sign up)
    public User addUser(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (users.containsKey(fullName)) {
            System.out.println("The name is already reserved. Please choose a different name.");
            return null;
        } else {
            User user = new User(firstName, lastName);
            users.put(fullName, user);
            System.out.println("The user has been added successfully.");
            return user;
        }
    }

    // Remove user (delete my user)
    public void removeUser(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (users.containsKey(fullName)) {
            users.remove(fullName);
            System.out.println("The user has been successfully deleted.");
        } else {
            System.out.println("The user doesn't exist.");
        }
    }

    // loginExistingUser (check if user exists and return it to use it)
    public User logInExistingUser(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (users.containsKey(fullName)) {
            System.out.println("Hi " + firstName + "! You are logged in now.");
            return users.get(fullName);
        } else {
            System.out.println("This user is not registered. Please try again.");
        } return null;
    }

}






