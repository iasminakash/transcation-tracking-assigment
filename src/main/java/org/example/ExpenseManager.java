package org.example;

import java.time.LocalDate;

public class ExpenseManager {
    //Methods
    public void addExpense(double amount, EExpenseCategory category, User loggedInUser){
        Expense expense = new Expense(amount, LocalDate.now(), category);
        loggedInUser.getExpenseArrayList().add(expense);
        System.out.println("The expense has been added successfully.");
    }

    public void displayExpenseList(User loggedInUser){
        for (Expense expense : loggedInUser.getExpenseArrayList()){
            System.out.println("____________________");
            System.out.println("The amount: " + expense.getAmount());
            System.out.println(("The category: " + expense.getCategory()));
            System.out.println("The date: " + expense.getDate());
            System.out.println("____________________");
        }

        }
    }

