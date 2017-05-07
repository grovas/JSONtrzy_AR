package com.sdajava.jsontrzy.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static com.sdajava.jsontrzy.utils.putJsonToCollection.readJsonData;
import static org.junit.Assert.assertEquals;

public class putJsonToCollectionTest {
    private static final String FILENAME = "users.json";
    private static JSONArray array = readJsonData(FILENAME);

    @Test
    public void shouldBeTenJsonObjects(){
        int howManyObj = array.size();
        assertEquals("Liczba obiektów = 10", howManyObj, 10);
    }

    @Test
    public void shouldBeEightElementsInObject() {
        Object obj = array.get(0);
        JSONObject json = (JSONObject) obj;
        int objSize = json.size();
        assertEquals("8 elementów w obiekcie", objSize, 8);
    }
}