package org.example;

import java.util.ArrayList;

public class User {

    private String firstName;

    private String lastName;


    private ArrayList <Income> incomeArrayList;

    private ArrayList <Expense> expenseArrayList;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.incomeArrayList = new ArrayList<>();
        this.expenseArrayList = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Income> getIncomeArrayList() {
        return incomeArrayList;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }




    }
