package com.sdajava.jsontrzy;

import com.sdajava.jsontrzy.model.Address;
import com.sdajava.jsontrzy.model.Person;
import com.sdajava.jsontrzy.utils.editDataInCollection;
import com.sdajava.jsontrzy.utils.saveUsersToJSONFile;

import java.io.IOException;
import java.util.List;

import static com.sdajava.jsontrzy.utils.putJsonToCollection.putDataToPersonList;
import static com.sdajava.jsontrzy.utils.putJsonToCollection.readJsonData;

public class Main {
    private static final String FILENAME = "users.json";
    private static final String FILEOUTNAME = "users_out.json";

    public static void main(String[] args) throws IOException {

        // readJsonData return JSONArray as direct argument to putDataToPersonList
        List<Person> personList = putDataToPersonList(readJsonData(FILENAME));
        // read last object in JSON and save to Person object
        Person person = personList.get(personList.size()-1);
        // print out whole list of object before edit
        personList.forEach(System.out::println);

        Address address = person.getAddress();
        editDataInCollection.changeCity(address, "Oakland");
        editDataInCollection.changeUsername(person,"Aisha");
        editDataInCollection.changeWebsite(person, "wp.pl");
        // print out whole list of object after edit
        personList.forEach(System.out::println);
        saveUsersToJSONFile.saveToJsonFile(personList, FILEOUTNAME);
    }
}
