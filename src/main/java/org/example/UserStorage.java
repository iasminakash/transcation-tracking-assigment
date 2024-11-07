package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class UserStorage {
    //Insansierar Gson objekt, snyggar till det
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //skaffar variabel fileName och ger det värde av ställen, där filen ska vara
    private String fileName = "src/main/user.json";

    //Metod för att skriva till JSON
    public void writeUsersToFile(HashMap<String, User> users) throws IOException {
        FileWriter fw = new FileWriter(fileName); // Open the file to write
        gson.toJson(users, fw);
        fw.close();
    }

    //Metod för att läsa från JSON
    public HashMap<String, User> readUserFromFile() throws IOException {
        FileReader fr = new FileReader(fileName);
        Type type = new TypeToken<HashMap<String, User>>() {
        }.getType();
        HashMap<String, User> users = gson.fromJson(fr, type);
        fr.close();
        return users;
    }

}
