package org.example;

import java.time.LocalDate;

public class IncomeManager {
    public void addIncome(double amount, EIncomeCategory category, User user){
        Income income = new Income (amount, LocalDate.now(), category);
        user.getIncomeArrayList().add(income);
        System.out.println("The income has been added successfully.");
    }

    public void displayIncomeList(User loggedInUser) {
        for (Income income : loggedInUser.getIncomeArrayList()){
            System.out.println("____________________");
            System.out.println("The amount: " + income.getAmount());
            System.out.println(("The category: " + income.getCategory()));
            System.out.println("The date: " + income.getDate());
            System.out.println("____________________");
        }
    }

    }


