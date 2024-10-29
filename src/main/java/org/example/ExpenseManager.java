package org.example;

//Manager klass som innnehåller metoder kopplade till utgifter

public class ExpenseManager {

   /* //Metoden som adderar utgift till listan, tar emot summa, kategori, user
    public void addExpense(double amount, EExpenseCategory category, User loggedInUser) {
        //insantierar en objekt av klasses expense och skickar med summa, datum, kategori
        Expense expense = new Expense(amount, LocalDate.now(), category);
        //anproppar getter för att se listan över utgifer, lägger till expense till användarens array över utgifter och skriver ut meddelande att transaktionen lyckades
        loggedInUser.getExpenseArrayList().add(expense);
        System.out.println("The expense has been added successfully.");
    }

    //Metoden för att ta bort en utgift, tar emot transaktionens nummer i listan, usern
    public void deleteExpense(int expenseTransactionNumber, User loggedInUser){
        //anropar getter för att visa users array över utgifter och tar bort en element enligt elementens index och skriver ut meddelande att transaktionen lyckades
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över utgifter
        loggedInUser.getExpenseArrayList().remove(expenseTransactionNumber-1);
        System.out.println("The expense has been deleted successfully.");
    }

    //Metoden för att ändra en summa i en viss utgift, tar emot user, ny summa, nummer av transaktionen i lista
    public void changeExpense(User loggedInUser, double newExpenseAmount, int expenseTransactionNumber) {
        //anropar getter för att få värde av utgifters array listans variabel, anroppar inbyggda metoden .get och tar vara på element i arrayen enligt indexet
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över utgifter
        //anger ny summa med hjälp av setter till variabeln amount
        loggedInUser.getExpenseArrayList().get(expenseTransactionNumber -1).setAmount(newExpenseAmount);
        //skriver ut en ny, ändrar lista över utgifter, för att användaren ska kunna se ändringen
        System.out.println("Here comes the updated list over your expense transactions.");
        displayExpenseList(loggedInUser);
    }

    //metoden för att visa lista över utgifter, tar emot user
    public void displayExpenseList(User loggedInUser) {
        //loppar genom array listan
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
*/
   // }



}

