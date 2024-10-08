package org.example;

import java.time.LocalDate;

public class ExpenseManager {
    //Methods
    public void addExpense(double amount, EExpenseCategory category, User user){
        Expense expense = new Expense(amount, LocalDate.now(), category);
        user.getExpenseArrayList().add(expense);
        System.out.println("The expense has been added successfully.");
    }
}
