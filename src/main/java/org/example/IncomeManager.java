package org.example;

import java.time.LocalDate;

public class IncomeManager {
    //Metoden som adderar utgift till listan, tar emot summa, kategori, user
    public void addIncome(double amount, EIncomeCategory category, User loggedInUser){
        Income income = new Income (amount, LocalDate.now(), category);
        loggedInUser.getIncomeArrayList().add(income);
        System.out.println("The income has been added successfully.");
    }

    public void deleteIncome(User loggedInUser, int incomeTransactionNumber){
        loggedInUser.getIncomeArrayList().remove((incomeTransactionNumber-1));
        System.out.println("The income translation is successfully removed.");
    }
    public void changeIncome(User loggedInUser, double newIncomeAmount, int incomeTransactionNumber) {
        loggedInUser.getIncomeArrayList().get(incomeTransactionNumber -1).setAmount(newIncomeAmount);
        System.out.println("Here comes the updated list over your income transactions.");
        displayIncomeList(loggedInUser);
    }

    public void displayIncomeList(User loggedInUser){
        for( int i = 0; i < loggedInUser.getIncomeArrayList().size(); i++){
            System.out.println("____________________");
            System.out.println("The income transaction number " + (i+1) + ":");
            System.out.println("The amount: " + loggedInUser.getIncomeArrayList().get(i).getAmount());
            System.out.println("The category: " + loggedInUser.getIncomeArrayList().get(i).getCategory());
            System.out.println("The date: " + loggedInUser.getIncomeArrayList().get(i).getDate());
            System.out.println("____________________");
        }
    }

    }


