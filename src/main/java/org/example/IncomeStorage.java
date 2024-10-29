package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class IncomeStorage {
    private Map<String, Income> incomes;
    private String fileName = "src/main/incomes.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, User>>() {
        }.getType();
        Reader reader = new FileReader(new File(fileName));
        incomes = gson.fromJson(reader, type);
    }

    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter(fileName);
        gson.toJson(incomes, fw);
        fw.close();
        System.out.println("File saved.");
    }

    public void addIncome(Income income) throws IOException {
        incomes.put(income.getDate(), income);
        System.out.println("Income added.");
        // vill du spara till fil här kan du göra det
        saveToFile();
    }
}
