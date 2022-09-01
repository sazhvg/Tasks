package com.company.details;

public class Engine {
    private String producer;
    private double power;

    public void setProducer(String producer){
        this.producer = producer;
    }
    public String getProducer() {
        return producer;
    }

    public void setPower(double power){
        this.power = power;
    }
    public double getPower() {
        return power;
    }

    public String toString() {
        return "Виробник: " + producer + ", міць двигуна: " + power + ";";
    }
}
