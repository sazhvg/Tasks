package com.ua.sazhyn.volodymyr;

import java.util.HashSet;

public class Car {

    private static HashSet<Car> freeCar = new HashSet<Car>();

    private String model;
    private int seats;
    private int baggageLiter;
    private double costOfKm;
    private int geoPositionCarKm;

    public Car(String model, int seats, int baggageLiter, double costOfKm) {
        this.model = model;
        this.seats = seats;
        this.baggageLiter = baggageLiter;
        this.costOfKm = costOfKm;
    }

    public double getCostOfKm() {
        return costOfKm;
    }

    public static HashSet<Car> getFreeCar() {
        return freeCar;
    }

    public int getGeoPositionCarKm() {
        return geoPositionCarKm;
    }

    public void setGeoPositionCarKm(int geoPositionCarKm) {
        this.geoPositionCarKm = geoPositionCarKm;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", seats=" + seats +
                ", baggageLiter=" + baggageLiter +
                ", costOfKm=" + costOfKm +
                '}';
    }
}
