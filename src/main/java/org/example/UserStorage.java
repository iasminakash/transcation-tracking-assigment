package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class UserStorage {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Map<String, User> userList;
    private  String fileName = "src/main/user.json";


    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, User>>() {}.getType();
        Reader reader = new FileReader(new File(fileName));
        userList = gson.fromJson(reader, type);
        System.out.println("User List:");
        for (String name : userList.keySet()) {
            System.out.println("Name: " + name);

        }
    }

    public void saveToFile(User user) throws IOException {
        userList.put(user.getUserName(), user);
        FileWriter fw = new FileWriter(fileName);
        gson.toJson(user, fw);
        fw.close();
        System.out.println("User saved.");
    }


}
