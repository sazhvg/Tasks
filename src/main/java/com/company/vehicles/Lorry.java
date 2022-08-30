package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class Lorry extends Car{

    private double load;

    public Lorry (){
        driver = new Driver();
        engine = new Engine();
    }

    public void setLoad(double load){
        this.load = load;
    }
    public double getload() {
        return load;
    }

    public String toString(){
        return "Інформація про авто: Марка: " + brCar + ", Клас " + classCar +", Вага " + weight +", вантажопід-йомністю кузова" +load +";" +
                driver + engine +".";
    }
}