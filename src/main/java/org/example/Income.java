package org.example;

import java.time.LocalDate;


//Klassen Income ärver från klassen Transaction
public class Income extends Transaction {

    private EIncomeCategory category;

    //// Klassens konstruktor, innehåller attribut från föräldrarklassens, super innehåller klassens egna attribut
    public Income(double amount, LocalDate date, EIncomeCategory category) {
        super(amount, date);
        this.category = category;
    }

    //Getter
    public EIncomeCategory getCategory() {
        return category;
    }

}
