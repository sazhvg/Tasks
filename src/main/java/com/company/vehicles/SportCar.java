package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class SportCar extends Car{

    private double maxSpeed;
    public SportCar (){
        driver = new Driver();
        engine = new Engine();
    }

    public void setMaxSpeed(double maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String toString(){
        return "Інформація про авто: Марка: " + brCar + ", Клас " + classCar +", Вага " + weight +", максимальна швидкість " +maxSpeed +";" +
                driver + engine +".";
    }

}