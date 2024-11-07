package org.example;

import java.util.Date;

//klasses Expense ärver från klassen Transaktion, har sitt egna attribut category
public class Expense extends Transaction {
    // Attributes
    private EExpenseCategory category;

    // Klassens konstruktor, innehåller attribut från föräldraklassens, super innehåller klassens egna attribut
    public Expense(double amount, Date date, EExpenseCategory category) {
        super(amount, date);
        this.category = category;
    }

    //Getter för kategori
    public EExpenseCategory getCategory() {
        return category;
    }

}
