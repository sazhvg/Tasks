package com.ua.sazhyn.volodymyr;

import java.util.HashSet;

public class Calculat {

    public static void calculatTax(HashSet<Car> freeCar, int geoPositionClientKm){

        geoPositionCar(Car.getFreeCar()); //Встановити поточне положення авто від клієнта
        double min = 0;
        double cost = 0;
        Car carMin = null;
        for (Car car:freeCar) {
            cost = (car.getGeoPositionCarKm() + geoPositionClientKm) * car.getCostOfKm();

            if (min > cost || min == 0) {
                min = cost;
                carMin = car;
            }
        }
        System.out.println("Авто: " + carMin +  ", вартість поїздки: " + min);
    }

    public static void geoPositionCar(HashSet<Car> cars){

        for (Car car:cars)   car.setGeoPositionCarKm((int) (Math.random()*10));

    }
}
