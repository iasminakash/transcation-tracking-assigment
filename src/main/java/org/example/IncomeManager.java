package org.example;

import java.time.LocalDate;

public class IncomeManager {
    public void addIncome(double amount, EIncomeCategory category, User user){
        Income income = new Income (amount, LocalDate.now(), category);
        user.getIncomeArrayList().add(income);
        System.out.println("The income has been added successfully.");
    }

    }


