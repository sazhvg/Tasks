package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class Lorry extends Car{

    private double load;

    public Lorry (Driver driver, Engine engine, String brCar, String  classCar, double weight){
        super(driver, engine, brCar, classCar, weight);
        this.load = load;
    }

    // методи (setDriver, getDriver, setEngine, getEngine) спадкються
    public void setLoad(double load){
        this.load = load;
    }
    public double getload() {
        return load;
    }

    public void start(){
        System.out.println("Стартую з Lorry");
    }
    public void stop(){
        System.out.println("Lorry зупиняємося");
    }
    public void turnRight() {
        System.out.println("Поворот Lorry направо");
    }
    public void turnLeft(){
        System.out.println("Поворот Lorry наліво");
    }

    public String toString(){
        return "Інформація про авто: Марка: " + getBrCar() + ", Клас " + getClassCar() +", Вага " + getWeight() +", вантажопід-йомністю кузова" +load +";" +
                getDriver() + getEngine() +".";
    }
}