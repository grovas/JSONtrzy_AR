package com.sdajava.jsontrzy.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.sdajava.jsontrzy.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class saveUsersToJSONFile {

    public static boolean saveToJsonFile (List<Person> person, String file) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(person, writer);
            writer.close();
            return true;
        } catch (JsonIOException | IOException e) {
            System.out.println(" " + e.getMessage());
        }
        return false;
    }

}
