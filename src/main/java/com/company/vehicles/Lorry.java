package com.company.vehicles;

public class Lorry extends Car{

    private double load;

    public Lorry (String name, String number, int age, String gender, int experience, String producer, double power){
        super(name,number, age, gender, experience, producer, power);
        this.load = load;
    }

    public void setLoad(double load){
        this.load = load;
    }
    public double getload() {
        return load;
    }

    public String toString(){
        return "Інформація про авто: Марка: " + getBrCar() + ", Клас " + getClassCar() +", Вага " + getWeight() +", вантажопід-йомністю кузова" +load +";" +
                driver + engine +".";
    }
}