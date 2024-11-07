package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class IncomeManager {

    HashMap<String, ArrayList<Income>> incomeHashMap = new HashMap<>();
    IncomeStorage incomeStorage = new IncomeStorage();

    public void setIncomeHashMap(HashMap<String, ArrayList<Income>> incomeHashMap) {
        this.incomeHashMap = incomeHashMap;
    }

    public HashMap<String, ArrayList<Income>> getIncomeHashMap() {
        return incomeHashMap;
    }

    //Metoden som adderar utgift till listan, tar emot summa, kategori, user
    public void addIncome(double amount, EIncomeCategory category, User loggedInUser) throws IOException {
        Income income = new Income(amount, new Date(), category);
        //anropar getter för att se listan över utgifter, lägger till expense till användarens array över inkomster och uppdaterar JSON filen med nyaderade utgift
        loggedInUser.getIncomeArrayList().add(income);
        incomeHashMap.put(loggedInUser.getUserId(), loggedInUser.getIncomeArrayList());
        incomeStorage.writeIncomeToFile(incomeHashMap);
        System.out.println("The income has been added successfully.");

    }

    //Metoden för att ta bort en inkomst transaction, tar emot transaktionens nummer i listan, usern
    public void deleteIncome(User loggedInUser, int incomeTransactionNumber) throws IOException {
        //anropar getter för att visa users arraylist över inkomst transaktioner och tar bort en element enligt elementens index
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över utgifter
        //uopdatterar i JSON filen
        loggedInUser.getIncomeArrayList().remove((incomeTransactionNumber - 1));
        incomeHashMap.put(loggedInUser.getUserId(), loggedInUser.getIncomeArrayList());
        incomeStorage.writeIncomeToFile(incomeHashMap);
        System.out.println("The income translation is successfully removed.");
    }

    //Metoden för att ändra en summa i en viss inkomst tar emot user, ny summa, nummer av transaktionen i lista
    public void changeIncome(User loggedInUser, double newIncomeAmount, int incomeTransactionNumber) throws IOException {
        //anropar getter för att få värde av utgifters array listans variabel, anropar inbyggda metoden .get och tar vara på element i arrayen enligt indexet
        //har -1 för att elementen i array numreras med 0,1,2,3 ej 1,2,3 som i utskriva lista över inkomster
        //anger ny summa med hjälp av setter till variabeln amount
        loggedInUser.getIncomeArrayList().get(incomeTransactionNumber - 1).setAmount(newIncomeAmount);
        //uppdaterar i JSON filen
        incomeHashMap.put(loggedInUser.getUserId(), loggedInUser.getIncomeArrayList());
        incomeStorage.writeIncomeToFile(incomeHashMap);
        //skriver ut en ny, dvs ändrad lista över utgifter, för att användaren ska kunna se ändringen
        System.out.println("Here comes the updated list over your income transactions.");
        displayIncomeList(loggedInUser);
    }

    //metoden för att visa lista över inkomster, tar emot user
    public void displayIncomeList(User loggedInUser) {
        //om listan existerar inte eller är tömm, skriver ut meddelande om att det inte finns några inkomsttransaktioner
        if (loggedInUser.getIncomeArrayList() == null || loggedInUser.getIncomeArrayList().isEmpty()) {
            System.out.println("No income found");
            System.out.println("____________________");
        }
        //annars loopar genom array listan och skriver ut alla objekt
        else {
            for (int i = 0; i < loggedInUser.getIncomeArrayList().size(); i++) {
                System.out.println("____________________");
                System.out.println("The income transaction number " + (i + 1) + ":");
                System.out.println("The amount: " + loggedInUser.getIncomeArrayList().get(i).getAmount());
                System.out.println("The category: " + loggedInUser.getIncomeArrayList().get(i).getCategory());
                System.out.println("The date: " + loggedInUser.getIncomeArrayList().get(i).getDate());
                System.out.println("____________________");
            }

        }
    }

}


