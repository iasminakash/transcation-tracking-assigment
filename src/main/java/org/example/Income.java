package org.example;

import java.time.LocalDate;

public class Income extends Transaction {

    private EIncomeCategory category;

    //Constructor

    public Income(double amount, LocalDate date, EIncomeCategory category) {
        super(amount, date);
        this.category = category;
    }

    //Getter

    public EIncomeCategory getCategory() {
        return category;
    }



}
