package org.example;

import java.util.Date;

//Klasses Transaktion är föräldrar klass till klasserna Expense och Income

public class Transaction {
    //den klassen har variablerna amount och date, som ska ärvas av Expense och Income
    private double amount;
    private Date date;

    //konstruktor, som ser till att objekt skaffas på ett speciellt sätt
    public Transaction(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    //getters
    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    //setter för summa
    public void setAmount(double amount) {
        this.amount = amount;
    }
}


