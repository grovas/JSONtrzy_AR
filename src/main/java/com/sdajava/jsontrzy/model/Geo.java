package com.sdajava.jsontrzy.model;

public class Geo {

    private Object lat;
    private Object lng;

    public Geo(Object lat, Object lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "\n\t\tlat=" + lat +
                ", \n\t\tlng=" + lng;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }
}
