package com.company.vehicles;
import com.company.details.Engine;
import com.company.professions.Driver;

public class Car {
    private String brCar, classCar;
    private double weight;
    public Driver driver;
    public Engine engine;

    public Car (String name, String number, int age, String gender, int experience, String producer, double power){
        driver = new Driver(name, number, age, gender, experience);
        engine = new Engine(producer, power);
        this.brCar = brCar;
        this.classCar = classCar;
        this.weight = weight;
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