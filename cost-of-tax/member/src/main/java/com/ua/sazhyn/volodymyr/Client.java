package com.ua.sazhyn.volodymyr;

public class Client {

    private String name;
    private int geoPositionClientKm;

    public Client(String name, int geoPositionClientKm) {
        this.name = name;
        this.geoPositionClientKm = geoPositionClientKm;
    }

    public String getName() {
        return name;
    }

    public int getGeoPositionClientKm() {
        return geoPositionClientKm;
    }
}
