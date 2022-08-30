package com.company.entities;

public class Person {
    private String name;
    private String number;
    private int age;
    private String gender;

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public void setAge(int age){
        this.age = age;
    }
    public double getAge() {
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public String toString() {
        return "ПІБ : " + name + ", номер тел.: " + number + ", вік: " + age + ", стать: " +
                gender +".";
    }
}
