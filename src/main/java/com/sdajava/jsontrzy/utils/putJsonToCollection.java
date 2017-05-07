package com.sdajava.jsontrzy.utils;

import com.sdajava.jsontrzy.model.Address;
import com.sdajava.jsontrzy.model.Company;
import com.sdajava.jsontrzy.model.Geo;
import com.sdajava.jsontrzy.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class putJsonToCollection {

    public static JSONArray readJsonData(String inputFile){
        JSONParser parser = new JSONParser();
        JSONArray array = null;

        try {
            File file = new File(inputFile);
            FileInputStream fileInputStream = new FileInputStream(file);
            /*
            To read JSON data from URL address uncomment below 2 lines
             */
            //URL url = new URL("https://jsonplaceholder.typicode.com/users");
            //URLConnection connect = url.openConnection();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(fileInputStream));

            array = (JSONArray) parser.parse(in);

            fileInputStream.close();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static List<Person> putDataToPersonList (JSONArray array) {
        List<Person> personList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        List<Geo> geoList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();

        for (Object obj : array) {

            JSONObject json = (JSONObject) obj;

            JSONObject resultAddress = (JSONObject) json.get("address");
            JSONObject resultGeo = (JSONObject) resultAddress.get("geo");
            geoList.add(new Geo(Double.parseDouble((String) resultGeo.get("lat")),
                                Double.parseDouble((String) resultGeo.get("lng"))
                    ));

            addressList.add(
                    new Address((String) resultAddress.get("street"),
                                (String) resultAddress.get("suite"),
                                (String) resultAddress.get("city"),
                                (String) resultAddress.get("zipcode"),
                                geoList.get(geoList.size()-1)
                    ));

            JSONObject resultComp = (JSONObject) json.get("company");
            companyList.add(
                    new Company((String) resultComp.get("name"),
                                (String) resultComp.get("catchPhrase"),
                                (String) resultComp.get("bs")
                    ));

            personList.add(
                    new Person( (long) json.get("id"),
                                (String) json.get("name"),
                                (String) json.get("username"),
                                (String) json.get("email"),
                                addressList.get(addressList.size()-1),
                                (String) json.get("phone"),
                                (String) json.get("website"),
                                companyList.get(companyList.size()-1)
                    ));
        }
        return personList;
    }
}
