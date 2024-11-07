package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

//Jag valde ha den Manager klassen för att avskilja alla metoder kopplade till utgifter

public class ExpenseManager {

    //HashMap expenseHashMap, string är nyckel och ArrayList av typen Expense är värde
    private HashMap<String, ArrayList<Expense>> expenseHashMap = new HashMap<>();
    //intsansierar objekt av typen expenseStorage
    ExpenseStorage expenseStorage = new ExpenseStorage();

    // getter och setter  för hashmapen expenseHashMap
    public HashMap<String, ArrayList<Expense>> getExpenseHashMap() {
        return expenseHashMap;
    }

    public void setExpenseHashMap(HashMap<String, ArrayList<Expense>> expenseHashMap) {
        this.expenseHashMap = expenseHashMap;
    }


    //Metoden som adderar utgift till listan, tar emot summa, kategori, user
    public void addExpense(double amount, EExpenseCategory category, User loggedInUser) throws IOException {
        //insantierar en objekt av klasses expense och skickar med summa, datum, kategori
        Expense expense = new Expense(amount, new Date(), category);
        //anropar getter för att se listan över utgifter, lägger till expense till användarens array över utgifter och uppdaterar JSON filen med nyaderade utgift
        loggedInUser.getExpenseArrayList().add(expense);
        expenseHashMap.put(loggedInUser.getUserId(), loggedInUser.getExpenseArrayList());
        expenseStorage.writeExpenseToFile(getExpenseHashMap());
        System.out.println("The expense has been added successfully.");
    }

    //Metoden för att ta bort en utgift, tar emot transaktionens nummer i listan, usern
    public void deleteExpense(int expenseTransactionNumber, User loggedInUser) throws IOException {
        //anropar getter för att visa users arraylist över utgifter och tar bort en element enligt elementens index
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över utgifter
        //uopdatterar i JSON filen
        loggedInUser.getExpenseArrayList().remove(expenseTransactionNumber - 1);
        expenseHashMap.put(loggedInUser.getUserId(), loggedInUser.getExpenseArrayList());
        expenseStorage.writeExpenseToFile(getExpenseHashMap());
        System.out.println("The expense has been deleted successfully.");
    }

    //Metoden för att ändra en summa i en viss utgift, tar emot user, ny summa, nummer av transaktionen i lista
    public void changeExpense(User loggedInUser, double newExpenseAmount, int expenseTransactionNumber) throws IOException {
        //anropar getter för att få värde av utgifters array listans variabel, anropar inbyggda metoden .get och tar vara på element i arrayen enligt indexet
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över utgifter
        //anger ny summa med hjälp av setter till variabeln amount
        loggedInUser.getExpenseArrayList().get(expenseTransactionNumber - 1).setAmount(newExpenseAmount);
        //uppdaterar i JSON filen
        expenseHashMap.put(loggedInUser.getUserId(), loggedInUser.getExpenseArrayList());
        expenseStorage.writeExpenseToFile(getExpenseHashMap());
        //skriver ut en ny, dvs ändrad lista över utgifter, för att användaren ska kunna se ändringen
        System.out.println("Here comes the updated list over your expense transactions.");
        displayExpenseList(loggedInUser);
    }

    //metoden för att visa lista över utgifter, tar emot user
    public void displayExpenseList(User loggedInUser) {
        //om listan existerar inte eller är tömm, skriver ut medelande om att det inte finns några utgifter
        if (loggedInUser.getExpenseArrayList() == null || loggedInUser.getExpenseArrayList().isEmpty()) {
            System.out.println("No expenses found");
            System.out.println("____________________");
        }
        //annars loopar genom array listan och skriver ut alla objekt
        else {
            for (int i = 0; i < loggedInUser.getExpenseArrayList().size(); i++) {
                System.out.println("____________________");
                //skaffar transaktionsnummer genom att addera 1 till indexet för att slippa att listan börjar på 0
                System.out.println("The expense transaction number " + (i + 1) + ":");
                //tar vara på array listan över utgifter, hittar elementet genom metoden get, visar summan, kategorin, datumet genom getters
                System.out.println("The amount: " + loggedInUser.getExpenseArrayList().get(i).getAmount());
                System.out.println("The category: " + loggedInUser.getExpenseArrayList().get(i).getCategory());
                System.out.println("The date: " + loggedInUser.getExpenseArrayList().get(i).getDate());
                System.out.println("____________________");
            }

        }

    }


}

