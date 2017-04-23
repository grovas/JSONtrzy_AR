package com.sdajava.jsontrzy.model;

public class Address {

    private Object street;
    private Object suite;
    private Object city;
    private Object zipcode;
    private Object geo;

    public Address(Object street, Object suite, Object city, Object zipcode, Object geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public Object getStreet() {
        return street;
    }

    public void setStreet(Object street) {
        this.street = street;
    }

    public Object getSuite() {
        return suite;
    }

    public void setSuite(Object suite) {
        this.suite = suite;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getZipcode() {
        return zipcode;
    }

    public void setZipcode(Object zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return  "\n\tstreet = " + street +
                ", \n\tsuite = " + suite +
                ", \n\tcity = " + city +
                ", \n\tzipcode = " + zipcode +
                ", \n\tgeo = " + geo.toString();
    }
}
