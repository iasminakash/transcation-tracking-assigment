package org.example;

//Klasses Transaktion är föräldrar klass till klasserna Expense och Income

    public class Transaction {
        private double amount;
        private String date;

        public Transaction(double amount, String date) {
            this.amount = amount;
            this.date = date;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
 /*//den klassen har variablerna amount och date, som ska ärvas av Expense och Income
        private double amount;
        private LocalDate date;
//konstruktor, som ser till att objekt skaffas på ett speciellt sätt
        public Transaction(double amount, LocalDate date) {
            this.amount = amount;
            this.date = date;
        }

        //getters
        public double getAmount() {
            return amount;
        }
        public LocalDate getDate() {
            return date;
        }

        //setter för summa
        public void setAmount(double amount) {
            this.amount = amount;
        }*/
    }


