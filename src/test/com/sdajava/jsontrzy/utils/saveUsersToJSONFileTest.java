package com.sdajava.jsontrzy.utils;

import com.sdajava.jsontrzy.model.Address;
import com.sdajava.jsontrzy.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.sdajava.jsontrzy.utils.saveUsersToJSONFile.saveToJsonFile;
import static org.junit.Assert.*;

public class saveUsersToJSONFileTest {

    private static String FILE = "user_out_test.json";

    @Test
    public void shouldReturnTrueIfPersonListAndFilePathExist (){
        Address address = new Address("Miastko");
        List<Person> person = Arrays.asList(new Person("Agnes", address));

        boolean result = saveToJsonFile(person, FILE);
        assertTrue("save file", result);
    }
}