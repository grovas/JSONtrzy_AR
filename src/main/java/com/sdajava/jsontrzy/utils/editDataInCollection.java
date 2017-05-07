package com.sdajava.jsontrzy.utils;

import com.sdajava.jsontrzy.model.Address;
import com.sdajava.jsontrzy.model.Person;

/**
 * Class to edit data in the list collected from JSON file
 */
public class editDataInCollection {
    /**
     *
     * @param person -
     * @param username
     */
    public static boolean changeUsername(Person person, String username){
        if (person == null || username == null)
            return false;
        else person.setName(username);
        return true;
    }

    public static boolean changeCity(Address address, String city){
        if (address == null|| city == null)
            return false;
        else address.setCity(city);
        return true;
    }

    public static boolean changeWebsite(Person person, String newWebsite){
        if (person == null || newWebsite == null)
            return false;
        else person.setWebsite(newWebsite);
        return true;
    }
}
