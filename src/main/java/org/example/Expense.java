package org.example;

import java.time.LocalDate;

//klasses Expense ärver från klassen Transaktion, har sitt egna attribut category
public class Expense extends Transaction {
    // Attributes
    private EExpenseCategory category;

    // Klassens konstruktor, innehåller attribut från föräldrarklassens, super innehåller klassens egna attribut
    public Expense(double amount, LocalDate date, EExpenseCategory category) {
        super(amount, date);
        this.category = category;
    }
     //Getter
    public EExpenseCategory getCategory() {
        return category;
    }

}
