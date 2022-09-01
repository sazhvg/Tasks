package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class SportCar extends Car{

    private double maxSpeed;
    public SportCar (Driver driver, Engine engine, String brCar, String  classCar, double weight){
        super(driver, engine, brCar, classCar, weight);
        this.maxSpeed = maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void start(){
        System.out.println("Стартую з SportCar");
    }
    public void stop(){
        System.out.println("SportCar зупиняємося");
    }
    public void turnRight() {
        System.out.println("Поворот SportCar направо");
    }
    public void turnLeft(){
        System.out.println("Поворот SportCar наліво");
    }


    public String toString(){
        return "Інформація про авто: Марка: " + getBrCar() + ", Клас " + getClassCar() +", Вага " + getWeight() +", максимальна швидкість " +maxSpeed +";" +
                getDriver() + getEngine() +".";
    }
}