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

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            URLConnection connect = url.openConnection();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connect.getInputStream()));

            String line;
            String dateToString;
            String[] substring;
            String startDate = "2016-12-01";
            String endDate = "2017-01-02";

            while ((line = in.readLine()) != null) {
                JSONArray array = (JSONArray) parser.parse(line);

                for (Object obj : array) {

                    JSONObject json = (JSONObject) obj;
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
