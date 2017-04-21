package com.sdajava.jsontrzy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        List<Object> personList = new ArrayList<>();
        List<Object> addressList = new ArrayList<>();
        List<Object> geoList = new ArrayList<>();
        List<Object> companyList = new ArrayList<>();

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            URLConnection connect = url.openConnection();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connect.getInputStream()));

            //while ((line = in.readLine()) != null) {
                JSONArray array = (JSONArray) parser.parse(in);

                for (Object obj : array) {

                    JSONObject json = (JSONObject) obj;

                    JSONObject resultA = (JSONObject) json.get("address");
                    geoList.add(resultA.get("geo"));

                    addressList.add(
                            new Address(resultA.get("street"),
                                    resultA.get("suite"),
                                    resultA.get("city"),
                                    resultA.get("zipcode"),
                                    geoList));

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
                            addressList,
                            json.get("phone"),
                            json.get("website"),
                            companyList));

                    System.out.println("json");
                }
           // }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
