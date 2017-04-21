package com.sdajava.jsontrzy;

import java.util.ArrayList;
import java.util.List;

public class Address {

    private Object street;
    private Object suite;
    private Object city;
    private Object zipcode;
    private List<Geo> geoList = new ArrayList<>();

    public Address(Object street, Object suite, Object city, Object zipcode, List<Geo> geoList) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geoList = geoList;
    }
}
