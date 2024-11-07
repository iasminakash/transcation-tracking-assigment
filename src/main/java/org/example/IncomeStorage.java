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

public class IncomeStorage {

    //Insansierar Gson objekt, snyggar till det
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //skaffar variabel fileName och ger det värde av ställen, där filen ska vara
    private String fileName = "src/main/income.json";


    //Metod för att skriva till JSON
    public void writeIncomeToFile(HashMap<String, ArrayList<Income>> incomeHashMap) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        gson.toJson(incomeHashMap, fw);
        fw.close();
    }

    //Metod för att läsa från JSON
    public HashMap<String, ArrayList<Income>> readIncomeFromFile() throws IOException {
        FileReader fr = new FileReader(fileName);
        Type type = new TypeToken<HashMap<String, ArrayList<Income>>>() {
        }.getType();
        HashMap<String, ArrayList<Income>> incomeHashMap = gson.fromJson(fr, type);
        fr.close();
        return incomeHashMap;
    }

}
