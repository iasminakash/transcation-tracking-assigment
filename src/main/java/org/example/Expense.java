package org.example;

import java.time.LocalDate;

public class Expense extends Transaction {
    // Attributes
    private EExpenseCategory category;

    // Constructor
    public Expense(double amount, LocalDate date, EExpenseCategory category) {
        super(amount, date);
        this.category = category;
    }
     //Getter
    public EExpenseCategory getCategory() {
        return category;
    }


}
