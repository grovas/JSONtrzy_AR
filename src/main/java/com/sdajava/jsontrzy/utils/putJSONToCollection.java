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

public class putJSONToCollection {

    public static final String FILEPATCH = "users.json";

    static  JSONParser parser = new JSONParser();

    static List<Object> personList = new ArrayList<>();
    static List<Object> addressList = new ArrayList<>();
    static List<Object> geoList = new ArrayList<>();
    static List<Object> companyList = new ArrayList<>();

    public static List<Object> readAndCollect(){
        try {

            File file = new File(FILEPATCH);
            FileInputStream fileInputStream = new FileInputStream(file);
            //URL url = new URL("https://jsonplaceholder.typicode.com/users");
            //URLConnection connect = url.openConnection();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(fileInputStream));

            //while ((line = in.readLine()) != null) {
            JSONArray array = (JSONArray) parser.parse(in);

            for (Object obj : array) {

                JSONObject json = (JSONObject) obj;

                JSONObject resultA = (JSONObject) json.get("address");
                JSONObject resultG = (JSONObject) resultA.get("geo");
                geoList.add(new Geo(resultG.get("lat"), resultG.get("lng")));

                addressList.add(
                        new Address(resultA.get("street"),
                                resultA.get("suite"),
                                resultA.get("city"),
                                resultA.get("zipcode"),
                                geoList.get(geoList.size()-1)));

                JSONObject resultC = (JSONObject) json.get("company");
                companyList.add(
                        new Company(resultC.get("name"),
                                resultC.get("catchPhrase"),
                                resultC.get("bs")));

                personList.add(
                        new Person(json.get("id"),
                                json.get("name"),
                                json.get("username"),
                                json.get("email"),
                                (Address) addressList.get(addressList.size()-1),
                                json.get("phone"),
                                json.get("website"),
                                (Company) companyList.get(companyList.size()-1)
                        ));
            }
        } catch (ParseException | IOException
                // | MalformedURLException
                e) {
            e.printStackTrace();
        }
        return personList;
    }
}
