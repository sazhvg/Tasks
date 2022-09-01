package com.company.vehicles;

public class SportCar extends Car{

    private double maxSpeed;
    public SportCar (String name, String number, int age, String gender, int experience, String producer, double power){
        super(name,number, age, gender, experience, producer, power);
        this.maxSpeed = maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String toString(){
        return "Інформація про авто: Марка: " + getBrCar() + ", Клас " + getClassCar() +", Вага " + getWeight() +", максимальна швидкість " +maxSpeed +";" +
                driver + engine +".";
    }
}