package com.sdajava.jsontrzy.utils;

import com.sdajava.jsontrzy.model.Address;
import com.sdajava.jsontrzy.model.Person;
import org.junit.Test;

import static com.sdajava.jsontrzy.utils.editDataInCollection.changeCity;
import static com.sdajava.jsontrzy.utils.editDataInCollection.changeUsername;
import static com.sdajava.jsontrzy.utils.editDataInCollection.changeWebsite;
import static org.junit.Assert.*;

public class editDataInCollectionTest {

    @Test
    public void shouldReturnTrueIfArgsAreNotNull (){
        Address address = new Address("Miastko");
        Person person = new Person("Agnes", address);

        boolean result1 = changeUsername(person, "Agata");
        boolean result2 = changeCity(address, "Wawa");
        boolean result3 = changeWebsite(person, "o2.pl");

        // assertion with shorten version eg.: result == true
        assertTrue("username test", result1);
        assertTrue("city test", result2);
        assertTrue("website test", result3);
    }
}