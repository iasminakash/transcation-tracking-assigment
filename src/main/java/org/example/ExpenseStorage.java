package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseStorage {

    //Insansierar Gson objekt, snyggar till det
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //skaffar variabel fileName och ger det värde av ställen, där filen ska vara
    private String fileName = "src/main/expense.json";

    //metoden för att skriva in till Json fil
    public void writeExpenseToFile(HashMap<String, ArrayList<Expense>> expenseHashmap) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        gson.toJson(expenseHashmap, fw);
        fw.close();
    }

    //metoden för att läsa från Json fil
    public HashMap<String, ArrayList<Expense>> readExpenseFromFile() throws IOException {
        FileReader fr = new FileReader(fileName);
        Type type = new TypeToken<HashMap<String, ArrayList<Expense>>>() {
        }.getType();
        HashMap<String, ArrayList<Expense>> expenseHashMap = gson.fromJson(fr, type);
        fr.close();
        return expenseHashMap;
    }


}
