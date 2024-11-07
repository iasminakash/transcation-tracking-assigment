package org.example;

import java.util.HashMap;

//Jag valde att lägga till den Manager klassen, för att ha här metoder som involverar user och userlistan
public class UserManager {

    //HashMap av users
    private HashMap<String, User> users = new HashMap<>();

    //getter och setter för users HashMap
    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    //metod för att lägga ny user, tar emot namn och efternamn
    public User addUser(String firstName, String lastName) {
        User newUser = new User(firstName, lastName);
        //loopar igenom HashMapen med alla users och hittar objekter med samma namn och efternamn som värden
        for (User existingUser : users.values()) {
            if (existingUser.getFirstName().equals(firstName) && existingUser.getLastName().equals(lastName)) {
                System.out.println("The name is already reserved. Please choose a different name.");
                //om det objektet existerar vi returnerar null
                return null;
            }
        }
        // ifall objektet existerar inte, dvs att inloggningen är inte använd av någon annan person, vi ska lägga till ny user
        users.put(newUser.getUserId(), newUser);
        System.out.println("The user has been added successfully.");
        //returnerar usern efter att jag lagt det usern till Hashmapen
        return newUser;
    }


    // Metoden för att ta bort user, tar emot userID
    // I min program ska bara kunna ta bort egna kontot och behöver vara inloggad då
    public void removeUser(String userId) {
        users.remove(userId);
        System.out.println("The user has been successfully deleted.");
    }

    // Metod för att logga in existerande användare, tar emot namn och efternamn
    public User logInExistingUser(String firstName, String lastName) {
        //loopar genom HashMapens värde för att hitta objektet user med samma namn och efternamn
        //ifall den hittar, så ska man loggas in
        for (User user : users.values())
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                return user;
            }
        //skriver ut felmeddelande ifall objekt med samma efternamn och namn hittas ej i HashMapen, returnerar null
        System.out.println("This user is not registered. Please try again.");
        return null;
    }

}






