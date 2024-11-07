package org.example;

import java.util.Date;


//Klassen Income ärver från klassen Transaction
public class Income extends Transaction {

    private EIncomeCategory category;


    //// Klassens konstruktor, innehåller attribut från föräldrarklassens, super innehåller klassens egna attribut
    public Income(double amount, Date date, EIncomeCategory category) {
        super(amount, date);
        this.category = category;
    }

    //Getter för kategori
    public EIncomeCategory getCategory() {
        return category;
    }

}
