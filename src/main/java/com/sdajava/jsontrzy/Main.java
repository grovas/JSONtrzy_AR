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

        List<Person> personList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        List<Geo> geoList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            URLConnection connect = url.openConnection();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connect.getInputStream()));

            String line;
            /*String dateToString;
            String[] substring;
            String startDate = "2016-12-01";
            String endDate = "2017-01-02";*/

            while ((line = in.readLine()) != null) {
                JSONArray array = (JSONArray) parser.parse(line);

                for (Object obj : array) {

                    JSONObject json = (JSONObject) obj;

                    JSONObject jsonGeo = (JSONObject) obj;
                    JSONArray results = (JSONArray) jsonGeo.get("geo");
                    JSONObject resultLat = (JSONObject) results.get(0);
                    JSONObject resultLng = (JSONObject) results.get(1);

                    geoList.add(new Geo(resultLat.get("lat").toString(), resultLng.get("lng").toString()));

                    JSONObject jsonAddress = (JSONObject) obj;
                    JSONArray addressArray = (JSONArray) jsonGeo.get("address");
                    JSONObject addressStreet = (JSONObject) addressArray.get(0);
                    JSONObject addressSuite = (JSONObject) addressArray.get(1);
                    JSONObject addressCity = (JSONObject) addressArray.get(2);
                    JSONObject addressZip = (JSONObject) addressArray.get(3);
                    JSONObject addressGeo = (JSONObject) addressArray.get(4);


                    addressList.add(new Address(json.get("street"),
                            json.get("suite"),
                            json.get("city"),
                            json.get("zipcode"),
                            geoList));

                    companyList.add(new Company(json.get("company").))

                    personList.add(new Person(json.get("id"),
                            json.get("name"),
                            json.get("username"),
                            json.get("email"),
                            addressList,
                            ))
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
