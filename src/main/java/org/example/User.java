package org.example;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    //User egna fält (properties)
    private String firstName;

    private String lastName;

    private String userId;

    //User egna listor över inkomster och utgifter
    private ArrayList<Income> incomeArrayList;

    private ArrayList<Expense> expenseArrayList;

    //konstruktor, varje ny user ska behöva ha namn och efternamn när man skaffar den
    //varje ny user kommer med tömma arraylistor, en över utgifter och en över inkomster
    //en unik user id skaffas for varje user med hjälp av UUID klassen
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.incomeArrayList = new ArrayList<>();
        this.expenseArrayList = new ArrayList<>();
        userId = UUID.randomUUID().toString();
    }

    //getters och setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<Income> getIncomeArrayList() {
        return incomeArrayList;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }

    public void setIncomeArrayList(ArrayList<Income> incomeArrayList) {
        this.incomeArrayList = incomeArrayList;
    }

    public void setExpenseArrayList(ArrayList<Expense> expenseArrayList) {
        this.expenseArrayList = expenseArrayList;
    }
}
