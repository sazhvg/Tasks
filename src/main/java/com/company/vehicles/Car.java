package com.company.vehicles;
import com.company.details.Engine;
import com.company.professions.Driver;

public class Car {
    protected String brCar, classCar;
    protected double weight;
    public Driver driver;
    public Engine engine;

    public Car (){
        driver = new Driver();
        engine = new Engine();
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

/*
    Створи похідний від Car клас - Lorry (вантажівка), який додатково характеризується також вантажопід-йомністю кузова.
    Створи похідний від Car класу - SportCar, який додатково характеризується також граничною швидкістю.
    Нехай клас Driver розширює клас Person.*/
}