package com.company.vehicles;
import com.company.details.Engine;
import com.company.professions.Driver;

public class Car {
    private String brCar, classCar;
    private double weight;
    private Driver driver;
    private Engine engine;

    public Car ( Driver driver, Engine engine, String brCar, String  classCar, double weight){
        this.driver = driver;
        this.engine = engine;
        this.brCar = brCar;
        this.classCar = classCar;
        this.weight = weight;
    }

    public void setDriver(String name, String number, int age, String gender, int experience) {
        driver = new Driver(name, number, age, gender, experience);
    }
    public Driver getDriver() {
        return driver;
    }

    public void setEngine(String producer, double power) {
        engine = new Engine(producer, power);
    }
    public Engine getEngine() {
        return engine;
    }


    public void setBrCar(String brCar){
        this.brCar = brCar;
    }
    public String getBrCar() {
        return brCar;
    }

    public void setClassCar(String classCar){
        this.classCar = classCar;
    }
    public String getClassCar() {
        return classCar;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public void start(){
        System.out.println("Поїхали");
    }
    public void stop(){
        System.out.println("Зупиняємося");
    }
    public void turnRight() {
        System.out.println("Поворот направо");
    }
    public void turnLeft(){
        System.out.println("Поворот наліво");
    }

    public String toString(){
        return "Інформація про авто: Марка: " + brCar + ", Клас " + classCar +";" + ", Вага " + weight +";" +
                 driver + engine +".";
    }
}